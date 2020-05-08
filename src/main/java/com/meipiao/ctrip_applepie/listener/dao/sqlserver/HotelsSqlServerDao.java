package com.meipiao.ctrip_applepie.listener.dao.sqlserver;

import com.meipiao.ctrip_applepie.listener.entity.sqlserver.Hotels;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 12:28
 */
@Repository
public interface HotelsSqlServerDao {

    //根据酒店id查询酒店信息
    @Select("select * from Hotels where Id = #{id}")
    Hotels queryById(Long id);
}
