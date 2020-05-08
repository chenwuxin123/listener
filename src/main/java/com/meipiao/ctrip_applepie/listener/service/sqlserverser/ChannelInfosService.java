package com.meipiao.ctrip_applepie.listener.service.sqlserverser;

import com.meipiao.ctrip_applepie.listener.dao.sqlserver.ChannelInfosSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.ChannelInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:02
 */
@Service
public class ChannelInfosService {

    @Autowired
    ChannelInfosSqlServerDao channelInfosSqlServerDao;

    public ChannelInfos queryByHotelId(Long hotelId, Long channelId) {
        return this.channelInfosSqlServerDao.queryByHotelId(hotelId, channelId);

    }
}
