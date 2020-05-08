package com.meipiao.ctrip_applepie.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meipiao.ctrip_applepie.listener.dao.sqlserver.ChannelInfosSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotel;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.ChannelInfos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.StringUtils;

@SpringBootTest
class ListenerApplicationTests {

    @Autowired
    ChannelInfosSqlServerDao channelInfosSqlServerDao;

    @Test
    void contextLoads() {
        ChannelInfos channelInfos = channelInfosSqlServerDao.queryByHotelId(50L, 1L);
        System.err.println(channelInfos.toString());

    }

}
