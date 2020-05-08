package com.meipiao.ctrip_applepie.listener.dao.mysql;

import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CtripinterHotel)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 15:58:47
 */
@Repository
public interface CtripinterHotelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
//    @Select("select * from ctripinter_hotel where id=#{id}")
    CtripinterHotel queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CtripinterHotel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ctripinterHotel 实例对象
     * @return 对象列表
     */
    List<CtripinterHotel> queryAll(CtripinterHotel ctripinterHotel);

    /**
     * 新增数据
     *
     * @param ctripinterHotel 实例对象
     * @return 影响行数
     */
    int insert(CtripinterHotel ctripinterHotel);

    /**
     * 修改数据
     *
     * @param ctripinterHotel 实例对象
     * @return 影响行数
     */
    int update(CtripinterHotel ctripinterHotel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


}