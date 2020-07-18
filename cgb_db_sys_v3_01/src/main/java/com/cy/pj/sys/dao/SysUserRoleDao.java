package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 基于此dao操作用户和角色关系表数据
 */
@Mapper
public interface SysUserRoleDao {
    /**
     * 基于角色id删除用户和角色关系数据
     */
    int deleteObjectsByRoleId(Integer roleId);
}
