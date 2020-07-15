package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 基于此dao执行角色，菜单关系的数据操作
 */
@Mapper
public interface SysRoleMenuDao {
    int deleteObjectsByMenuId(Integer menuId);
}
