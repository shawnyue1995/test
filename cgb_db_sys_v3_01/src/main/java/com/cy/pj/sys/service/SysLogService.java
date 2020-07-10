package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.pojo.SysLog;
import org.springframework.stereotype.Service;

@Service
public interface SysLogService {
    PageObject<SysLog> findPageObjects(String username, Integer pageCurrent);
}
