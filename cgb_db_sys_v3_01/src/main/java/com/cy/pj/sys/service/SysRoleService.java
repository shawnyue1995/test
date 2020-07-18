package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;

public interface SysRoleService {
    int updateObject(SysRole entity, Integer[] menuIds);

    SysRoleMenu findObjectById(Integer id);

    PageObject<SysRole> findPageObjects(
            String name, Integer PageCurrent);

    int deleteObject(Integer id);

    int saveObject(SysRole entity, Integer[] menuIds);

}
