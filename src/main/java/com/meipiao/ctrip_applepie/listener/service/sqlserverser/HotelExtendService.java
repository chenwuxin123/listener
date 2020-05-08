package com.meipiao.ctrip_applepie.listener.service.sqlserverser;

import com.meipiao.ctrip_applepie.listener.dao.sqlserver.HotelExtendSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:43
 */
@Service
public class HotelExtendService {
    @Autowired
    HotelExtendSqlServerDao hotelExtendSqlServerDao;

    public List<HotelExtend> queryByHotelId(Long hotelId) {
        return this.hotelExtendSqlServerDao.queryByHotelId(hotelId);
    }
}
