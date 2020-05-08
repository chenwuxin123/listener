package com.meipiao.ctrip_applepie.listener.service.sqlserverser;

import com.meipiao.ctrip_applepie.listener.dao.sqlserver.HotelCheckInPolicysSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelCheckInPolicys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:59
 */
@Service
public class HotelCheckInPolicysService {

    @Autowired
    HotelCheckInPolicysSqlServerDao hotelCheckInPolicysSqlServerDao;

    public HotelCheckInPolicys queryByHotelId(Long hotelId) {
        return this.hotelCheckInPolicysSqlServerDao.queryByHotelId(hotelId);
    }
}
