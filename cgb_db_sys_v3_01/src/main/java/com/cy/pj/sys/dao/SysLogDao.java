package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogDao {
    /**
     * 基于条件查询用户行为日志记录总数
     *
     * @param username 查询条件
     * @return 查询到的记录总数
     */
    int getRowCount(String username);

    /**
     * 基于条件查询当前页记录
     *
     * @param username   查询条件
     * @param startIndex 当前页数据的起始位设置(用于limit子句)
     * @param pageSize   当前页面大小(每页最多显示多少条记录)
     * @return 查询到的记录
     */

    List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize);
}
