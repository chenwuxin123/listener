package com.meipiao.ctrip_applepie.listener.dao.mysql;

import com.meipiao.ctrip_applepie.listener.entity.mysql.CtripinterHotelInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CtripinterHotelInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 15:52:02
 */
@Repository
public interface CtripinterHotelInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CtripinterHotelInfo> queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CtripinterHotelInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ctripinterHotelInfo 实例对象
     * @return 对象列表
     */
    List<CtripinterHotelInfo> queryAll(CtripinterHotelInfo ctripinterHotelInfo);

    /**
     * 新增数据
     *
     * @param ctripinterHotelInfo 实例对象
     * @return 影响行数
     */
    int insert(CtripinterHotelInfo ctripinterHotelInfo);

    /**
     * 修改数据
     *
     * @param ctripinterHotelInfo 实例对象
     * @return 影响行数
     */
    int update(CtripinterHotelInfo ctripinterHotelInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}