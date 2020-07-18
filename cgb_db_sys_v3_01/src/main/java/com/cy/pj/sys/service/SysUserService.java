package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysUserDept;

public interface SysUserService {
    PageObject<SysUserDept> findPageObjects(String name, Integer pageCurrent);

    int validById(Integer id, Integer valid);
}
