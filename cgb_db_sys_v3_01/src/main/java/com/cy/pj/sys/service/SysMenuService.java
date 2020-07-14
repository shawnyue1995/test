package com.cy.pj.sys.service;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.pojo.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {

    int updateObject(SysMenu entity);

    int saveObject(SysMenu entity);

    List<Node> findZtreeMenuNodes();

    List<Map<String, Object>> findObjects();

    int deleteObject(Integer id);

}
