package com.meipiao.ctrip_applepie.listener.service.sqlserverser;

import com.meipiao.ctrip_applepie.listener.dao.sqlserver.HotelDistributorRelationSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelDistributorRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:47
 */
@Service
public class HotelDistributorRelationService {
    @Autowired
    HotelDistributorRelationSqlServerDao hotelDistributorRelationSqlServerDao;

    public List<HotelDistributorRelation> queryByHotelId(Long hotelId) {
        return this.hotelDistributorRelationSqlServerDao.queryByHotelId(hotelId);
    }
}
