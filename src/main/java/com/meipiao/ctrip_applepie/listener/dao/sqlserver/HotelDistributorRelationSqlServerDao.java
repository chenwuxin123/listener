package com.meipiao.ctrip_applepie.listener.dao.sqlserver;

import com.meipiao.ctrip_applepie.listener.entity.sqlserver.HotelDistributorRelation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 12:28
 */
@Repository
public interface HotelDistributorRelationSqlServerDao {

    @Select("select * from HotelDistributorRelation where HotelId = #{hotelId}")
    List<HotelDistributorRelation> queryByHotelId(Long hotelId);
}
