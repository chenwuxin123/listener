package com.meipiao.ctrip_applepie.listener.dao.sqlserver;

import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelExtend;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 12:28
 */
@Repository
public interface HotelExtendSqlServerDao {

    @Select("select * from HotelExtend where HotelId = #{hotelId}")
    List<HotelExtend> queryByHotelId(Long hotelId);
}
