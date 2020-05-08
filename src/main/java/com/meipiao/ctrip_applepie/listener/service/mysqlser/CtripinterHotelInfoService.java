package com.meipiao.ctrip_applepie.listener.service.mysqlser;

import com.meipiao.ctrip_applepie.listener.dao.mysql.CtripinterHotelInfoDao;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotelInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 14:19
 */
@Service
@Slf4j
public class CtripinterHotelInfoService {

    @Autowired
    CtripinterHotelInfoDao ctripinterHotelInfoDao;

    @Transactional(transactionManager = "mysqlTransactionManager")
    public String ininsertHotelInfo(CtripinterHotelInfo ctripinterHotelInfo) {

        String className = this.getClass().getName();

        if (!StringUtils.isEmpty(ctripinterHotelInfo.getCtripinterHotelId())) {
            try {
                int insert = ctripinterHotelInfoDao.insert(ctripinterHotelInfo);
                if (insert < 1) {
                    return className + "没有任何添加";
                }
                return className + "成功添加" + insert + "条数据";
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error("{}:酒店id为{}:添加失败,请人工处理!", e.getMessage(), ctripinterHotelInfo.getCtripinterHotelId());
            }
        }
        return className + "对象内容为空,请重试";
    }

    public List<CtripinterHotelInfo> queryById(Long hotelId) {
        return ctripinterHotelInfoDao.queryById(hotelId);
    }
}
