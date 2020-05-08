package com.meipiao.ctrip_applepie.listener.service.mysqlser;

import com.meipiao.ctrip_applepie.listener.dao.mysql.CtripinterHotelDao;
import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.thymeleaf.util.StringUtils;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 9:01
 */
@Service
@Slf4j
public class CtripinterHotelService {

    @Autowired
    CtripinterHotelDao ctripinterHotelDao;

    @Transactional(transactionManager = "mysqlTransactionManager")
    public String insertHotel(CtripinterHotel ctripinterHotel) {
        String className = this.getClass().getName();

        if (!StringUtils.isEmpty(ctripinterHotel.getHotelCode())) {
            try {
                int insert = ctripinterHotelDao.insert(ctripinterHotel);
                if (insert < 1) {
                    return className + "没有任何添加";
                }
                return className + "成功添加" + insert + "条数据";
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                log.error("{}:酒店id为{}:添加失败,请人工处理!", e.getMessage(), ctripinterHotel.getId());
            }
        }
        return className + "对象内容为空,请重试";
    }

    //更新状态
    @Transactional(transactionManager = "mysqlTransactionManager")
    public String changeStatus(CtripinterHotel ctripinterHotel) {

        String className = this.getClass().getName();
        if (!StringUtils.isEmpty(ctripinterHotel.getHotelCode())) {
            try {
                int update = ctripinterHotelDao.update(ctripinterHotel);
                if (update < 1) {
                    return className + "更新成功";
                }
                return className + "成功更新" + update + "行数据";
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error("{}:酒店id为{}:更新失败,请人工处理!", e.getMessage(), ctripinterHotel.getId());
            }
        }
        return className + "对象内容为空,请重试";
    }

    //查询
    public CtripinterHotel queryById(Long hotelId) {
        return this.queryById(hotelId);
    }
}
