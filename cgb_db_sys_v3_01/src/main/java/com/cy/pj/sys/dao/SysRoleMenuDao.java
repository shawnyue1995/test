package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 基于此dao执行角色，菜单关系的数据操作
 */
@Mapper
public interface SysRoleMenuDao {

    int insertObjects(@Param("roleId") Integer roleId,
                      @Param("menuIds") Integer[] menuIds);

    /**
     * 基于角色ID删除用户和角色菜单关系数据
     */
    int deleteObjectsByMenuId(Integer menuId);

    /**
     * 基于菜单id删除角色菜单关系数据
     */
    int deleteObjectsByRoleId(Integer roleId);
}
