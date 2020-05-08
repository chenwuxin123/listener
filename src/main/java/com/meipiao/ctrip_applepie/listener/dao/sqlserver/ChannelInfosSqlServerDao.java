package com.meipiao.ctrip_applepie.listener.dao.sqlserver;

import com.meipiao.ctrip_applepie.listener.entity.sqlserver.ChannelInfos;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Chenwx
 * @Date: 2020/4/5 14:50
 */
@Repository
public interface ChannelInfosSqlServerDao {

    @Select("select c.* from  HotelOriginRelation h , ChannelInfos c \n" +
            "WHERE  h.HotelId = #{hotelId} AND c.Id = #{channelId}")
    ChannelInfos queryByHotelId(@Param("hotelId") Long hotelId, @Param("channelId") Long channelId);
}
