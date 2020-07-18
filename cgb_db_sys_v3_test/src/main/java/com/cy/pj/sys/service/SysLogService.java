package com.cy.pj.sys.service;

import com.cy.pj.sys.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysLog;

public interface SysLogService {
    PageObject<SysLog> findObjects(String name, Integer pageCurrent);
}
