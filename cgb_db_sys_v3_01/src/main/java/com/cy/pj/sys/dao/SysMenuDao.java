package com.cy.pj.sys.dao;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {

    int updateObject(SysMenu entity);

    int insertObject(SysMenu entity);

    List<Node> findZtreeMenuNodes();

    /**
     * 删除菜单自身信息
     *
     * @param id
     * @return
     */
    int deleteObject(Integer id);

    /**
     * 基于菜单id获取菜单对应的子菜单
     *
     * @param id
     * @return
     */
    int getChildCount(Integer id);

    /**
     * 查询所有菜单信息以及菜单对应的上级菜单
     *
     * @return
     */
    List<Map<String, Object>> findObjects();
}
