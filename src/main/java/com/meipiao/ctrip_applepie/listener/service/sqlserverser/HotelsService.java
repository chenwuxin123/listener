package com.meipiao.ctrip_applepie.listener.service.sqlserverser;

import com.meipiao.ctrip_applepie.listener.dao.sqlserver.HotelsSqlServerDao;
import com.meipiao.ctrip_applepie.listener.entity.sqlserver.Hotels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.sql.SQLException;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:07
 */
@Service
public class HotelsService {

    Logger log = LoggerFactory.getLogger(HotelsService.class);

    @Autowired
    HotelsSqlServerDao hotelsSqlServerDao;

    //查询Hotels信息
    public Hotels queryById(Long id) {
        return hotelsSqlServerDao.queryById(id);
    }
}
