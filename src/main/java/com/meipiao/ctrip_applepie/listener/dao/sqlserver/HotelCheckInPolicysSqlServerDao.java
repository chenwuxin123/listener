package com.meipiao.ctrip_applepie.listener.dao.sqlserver;

import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelCheckInPolicys;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 12:28
 */
@Repository
public interface HotelCheckInPolicysSqlServerDao {

    @Select("select * from HotelCheckInPolicys where HotelId = #{hotelId}")
    HotelCheckInPolicys queryByHotelId(Long hotelId);
}
