package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {
    int deleteObject(Integer id);

    int getChildCount(Integer id);

    /**
     * 查询所有菜单信息以及菜单对应的上级菜单
     *
     * @return
     */
    List<Map<String, Object>> findObjects();
}
