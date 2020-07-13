package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogDao {
    /**
     * 基于id执行删除操作
     *
     * @param ids 记录id（可变参数）
     * @return
     */
    int deleteObjects(@Param("ids") Integer... ids);

    /**
     * 基于条件查询用户行为日志记录总数
     *
     * @param username 查询条件
     * @return 查询到的记录总数
     */
    int getRowCount(@Param("username") String username);

    /**
     * 基于条件查询当前页记录
     *
     * @param username   查询条件
     * @param startIndex 当前页数据的起始位设置（用于limit 子句）
     * @param pageSize   当前页面大小(每页最多显示多少条记录)
     * @return 查询到的记录
     */

    List<SysLog> findPageObjects(@Param("username") String username,
                                 @Param("startIndex") Integer startIndex,
                                 @Param("pageSize") Integer pageSize);
}
