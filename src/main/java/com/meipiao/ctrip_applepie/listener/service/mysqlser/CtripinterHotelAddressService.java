package com.meipiao.ctrip_applepie.listener.service.mysqlser;

import com.meipiao.ctrip_applepie.listener.dao.mysql.CtripinterHotelAddressDao;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotelAddress;
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
 * @Date: 2020/4/2 13:39
 */
@Service
@Slf4j
public class CtripinterHotelAddressService {

    @Autowired
    CtripinterHotelAddressDao ctripinterHotelAddressDao;

    @Transactional(transactionManager = "mysqlTransactionManager")
    public String ininsertHotelAddress(CtripinterHotelAddress ctripinterHotelAddress) {
        String className = this.getClass().getName();

        if (!StringUtils.isEmpty(ctripinterHotelAddress.getCtripinterHotelId())) {
            try {
                int insert = ctripinterHotelAddressDao.insert(ctripinterHotelAddress);
                if (insert < 1) {
                    return className + "没有任何添加";
                }
                return className + "成功添加" + insert + "条数据";
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error("{}:酒店id为{}:添加失败,请人工处理!", e.getMessage(), ctripinterHotelAddress.getCtripinterHotelId());
            }
        }
        return className + "对象内容为空,请重试";
    }

    public List<CtripinterHotelAddress> queryById(Long hotelId) {
        return this.ctripinterHotelAddressDao.queryById(hotelId);
    }
}

