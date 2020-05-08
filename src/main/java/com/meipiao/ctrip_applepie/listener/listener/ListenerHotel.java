package com.meipiao.ctrip_applepie.listener.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meipiao.ctrip_applepie.listener.constant.RabbitMqConstant;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotel;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotelAddress;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotelInfo;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.ChannelInfos;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelExtend;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.Hotels;
import com.meipiao.ctrip_applepie.listener.service.mysqlser.CtripinterHotelAddressService;
import com.meipiao.ctrip_applepie.listener.service.mysqlser.CtripinterHotelInfoService;
import com.meipiao.ctrip_applepie.listener.service.mysqlser.CtripinterHotelService;
import com.meipiao.ctrip_applepie.listener.service.sqlserverser.ChannelInfosService;
import com.meipiao.ctrip_applepie.listener.service.sqlserverser.HotelExtendService;
import com.meipiao.ctrip_applepie.listener.service.sqlserverser.HotelsService;
import com.meipiao.ctrip_applepie.listener.utils.GetPosXmlUtil;
import com.meipiao.ctrip_applepie.listener.utils.GetPushXmlUtil;
import com.meipiao.ctrip_applepie.listener.utils.GzipUtil;
import com.meipiao.ctrip_applepie.listener.utils.HttpClientCallSoapUtil;
import lombok.extern.slf4j.Slf4j;
import org.anyline.entity.DataRow;
import org.anyline.entity.DataSet;
import org.anyline.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 9:15
 * @Des: 监听酒店事件 (暂报异常为admin没有访问权限)
 */
@Component
@Slf4j
public class ListenerHotel {

    //推送的URL
    @Value("${ctrip.HotelStaticInfoServiceUrl}")
    private String HotelStaticInfoServiceUrl;

    //sqlserver
    @Autowired
    HotelsService hotelsService;

    @Autowired
    HotelExtendService hotelExtendService;

    @Autowired
    ChannelInfosService channelInfosService;

    //mysql
    @Autowired
    CtripinterHotelService ctripinterHotelService;

    @Autowired
    CtripinterHotelAddressService ctripinterHotelAddressService;

    @Autowired
    CtripinterHotelInfoService ctripinterHotelInfoSer;

    //自动创建队列，Exchange 与 Queue绑定 key为路由名称,酒店添加事件
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(RabbitMqConstant.HOTEL_PUSH_QUEUE),
            exchange = @Exchange(RabbitMqConstant.HOTEL_EXCHANGE),
            key = {RabbitMqConstant.HOTEL_KEY}
    ))
    public void hotelPush(String message) {

        // String msg = GzipUtil.uncompressToString(message, "UTF-8");//传递过来的是GZIP

        JSONObject jsonObject = JSONObject.parseObject(message);
        Long hotelId = (Long) jsonObject.get("HotelId");    //传递过来的hotelId
        Long channelId = (Long) jsonObject.get("ChannelId"); //传递过来的channelId
        if (hotelId != null && channelId != null) {
            //执行信息
            String addressMsg = "";
            String infoMsg = "";

            //获取当前Date时间
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(new Date());
            ParsePosition pos = new ParsePosition(8);
            Date nowTime = formatter.parse(dateString, pos);

            //从ROC查询（sqlserver）
            Hotels hotels = hotelsService.queryById(hotelId);

            List<HotelExtend> hotelExtends = hotelExtendService.queryByHotelId(hotelId);//酒店Title，中英文cn & en

            /*渠道信息
             *	ChannelType 渠道类型 0：销售 1：采购
             * 	DataFlag    有效无效 0：无效 1：有效
             */
            ChannelInfos channelInfos = channelInfosService.queryByHotelId(hotelId, channelId);

            //酒店状态0: 待审核 1：已审核 2：已生效
            String hotelStatus = null;
            if (hotels.getStatus() == 0) {
                hotelStatus = "Check";
            } else if (hotels.getStatus() == 1) {
                hotelStatus = "Active";
            } else {
                hotelStatus = "Active";
            }

            //添加ctripinter_hotel(mysql)
            CtripinterHotel ctripinterHotel = new CtripinterHotel();
            ctripinterHotel.setId(hotelId);//酒店id
            ctripinterHotel.setHotelCode("TT" + String.valueOf(hotelId + 10000));//酒店代码 TT+hotelId
            ctripinterHotel.setHotelCategory(hotels.getHotelStar() + "星级酒店");//类型
            ctripinterHotel.setLatitude(hotels.getLat());//经度
            ctripinterHotel.setLongitude(hotels.getLon());//纬度
            ctripinterHotel.setHotelStatus(hotelStatus);//状态
            ctripinterHotel.setRegTime(nowTime);//注册日期
            ctripinterHotel.setUptTime(nowTime);//更新日期
            ctripinterHotel.setDataStatus(channelInfos.getDataFlag());//数据有效状态
            String hotelMsg = ctripinterHotelService.insertHotel(ctripinterHotel);

            //添加ctripinter_hotel_xx(mysql)
            CtripinterHotelAddress ctripinterHotelAddress = new CtripinterHotelAddress();//地址
            CtripinterHotelInfo ctripinterHotelInfo = new CtripinterHotelInfo();//其他信息

            for (HotelExtend hotelExtend : hotelExtends) {
                //公共address信息
                ctripinterHotelAddress.setCtripinterHotelId(hotelId);
                ctripinterHotelAddress.setRegTime(nowTime);
                ctripinterHotelAddress.setUptTime(nowTime);
                ctripinterHotelAddress.setDataStatus(channelInfos.getDataFlag());
                //公共info信息
                ctripinterHotelInfo.setCtripinterHotelId(hotelId);
                ctripinterHotelInfo.setRegTime(nowTime);
                ctripinterHotelInfo.setUptTime(nowTime);
                ctripinterHotelInfo.setDataStatus(channelInfos.getDataFlag());

                if ("cn".equals(hotelExtend.getLanguage())) {
                    //当编码是中文时,添加address
                    ctripinterHotelAddress.setLanguage("zh-CN");
                    ctripinterHotelAddress.setCountry(hotelExtend.getCountry());
                    ctripinterHotelAddress.setCity(hotelExtend.getCity());
                    ctripinterHotelAddress.setAddressLine(hotelExtend.getAddress());
                    ctripinterHotelAddress.setCode("CN");

                    //当编码是中文时,添加info
                    ctripinterHotelInfo.setLanguage("zh-CN");
                    ctripinterHotelInfo.setTitle(hotelExtend.getTitle());

                } else if ("en".equals(hotelExtend.getLanguage())) {
                    //当编码是英文时
                    ctripinterHotelAddress.setLanguage("en-US");
                    ctripinterHotelAddress.setCountry(hotelExtend.getCountry());
                    ctripinterHotelAddress.setCity(hotelExtend.getCity());
                    ctripinterHotelAddress.setAddressLine(hotelExtend.getAddress());
                    ctripinterHotelAddress.setCode("CN");

                    //当编码是英文时,添加info
                    ctripinterHotelInfo.setLanguage("en-US");
                    ctripinterHotelInfo.setTitle(hotelExtend.getTitle());
                } else {
                    //当编码两者都不是
                    ctripinterHotelAddress.setCountry(hotelExtend.getCountry());
                    ctripinterHotelAddress.setCity(hotelExtend.getCity());
                    ctripinterHotelAddress.setAddressLine(hotelExtend.getAddress());
                    ctripinterHotelAddress.setCode("CN");

                    ctripinterHotelInfo.setTitle(hotelExtend.getTitle());
                }
                addressMsg = ctripinterHotelAddressService.ininsertHotelAddress(ctripinterHotelAddress);
                infoMsg = ctripinterHotelInfoSer.ininsertHotelInfo(ctripinterHotelInfo);
            }

            log.info(hotelMsg);

            log.info(addressMsg);

            log.info(infoMsg);
        } else {
            log.info("队列参数为空");
        }

    }

    //开启\屏蔽信息变动
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(RabbitMqConstant.HOTEL_CHANGE_QUEUE),
            exchange = @Exchange(RabbitMqConstant.HOTEL_EXCHANGE),
            key = {RabbitMqConstant.HOTEL_KEY}
    ))
    public void hotelChange(String message) throws Exception {

        //String msg = GzipUtil.uncompressToString(message, "UTF-8");//传递过来的是GZIP

        JSONObject jsonObject = JSONObject.parseObject(message);
        Long hotelId = (Long) jsonObject.get("HotelId");    //传递过来的hotelId
        Long channelId = (Long) jsonObject.get("ChannelId"); //传递过来的channelId

        if (hotelId != null && channelId != null) {
            CtripinterHotel hotel = new CtripinterHotel();
            ChannelInfos channelInfos = channelInfosService.queryByHotelId(hotelId, channelId);
            hotel.setDataStatus(channelInfos.getDataFlag());
            hotel.setId(hotelId);
            //更改酒店状态
            ctripinterHotelService.changeStatus(hotel);

            //推送携程
            CtripinterHotel ctripinterHotel = ctripinterHotelService.queryById(hotelId);

            List<CtripinterHotelInfo> ctripinterHotelInfos = ctripinterHotelInfoSer.queryById(hotelId);

            List<CtripinterHotelAddress> ctripinterHotelAddresses = ctripinterHotelAddressService.queryById(hotelId);

            DataRow row = new DataRow();
            //POS节点相关信息
            row = GetPosXmlUtil.getPos(row);
            row.put("HotelCode", ctripinterHotel.getHotelCode());//酒店代码
            row.put("HotelStatus", ctripinterHotel.getHotelStatus());//房间状态
            row.put("Longitude", ctripinterHotel.getLongitude());//经度
            row.put("Latitude", ctripinterHotel.getLatitude());//纬度
            boolean isShow = ctripinterHotel.getIsShow() != null && 1 == ctripinterHotel.getIsShow();
            row.put("Visible", isShow);

            //酒店名称,多组(分中英文)
            DataSet subSet = new DataSet();
            for (CtripinterHotelInfo ctripinterHotelInfo : ctripinterHotelInfos) {
                DataRow subRow = new DataRow();
                subRow.put("Language", ctripinterHotelInfo.getLanguage());//语言
                subRow.put("Title", ctripinterHotelInfo.getTitle());//酒店名称
                subSet.add(subRow);
            }
            row.put("Info-array", subSet);

            //酒店位置(中英文)
            subSet = new DataSet();
            for (CtripinterHotelAddress ctripinterHotelAddress : ctripinterHotelAddresses) {
                DataRow subRow = new DataRow();
                subRow.put("CountryName-notag", ctripinterHotelAddress.getCountry());//国家
                subRow.put("CityName-notag", ctripinterHotelAddress.getCity());//城市
                subRow.put("AddressLine-notag", ctripinterHotelAddress.getAddressLine());//地址
                subRow.put("PostalCode-notag", ctripinterHotelAddress.getPostalCode());//邮编
                subRow.put("Code", ctripinterHotelAddress.getCode());
                subRow.put("Language", ctripinterHotelAddress.getLanguage());
                subSet.add(subRow);
            }
            row.put("Address-array", subSet);

            /**
             * 将对象信息写入xml并推送
             * 响应中的状态并不代表实际状态，使用OTA_HotelStatsNotif进行检查
             */
            String templateUrl = "ctripxml/HotelDescriptiveContentNotifRQ.xml";//模板路径
            log.info(HotelStaticInfoServiceUrl);
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templateUrl);
            StringBuffer sb = FileUtil.read(inputStream, "UTF-8");
            String xml = sb.toString();
            String xmlData = GetPushXmlUtil.getXml(xml, row);

            String ctripResponse = HttpClientCallSoapUtil.doPostSoap1_1(HotelStaticInfoServiceUrl, xmlData, "");
            log.info("返回的信息" + ctripResponse);
        } else {
            log.info("队列参数为空");
        }
    }

}
