package com.cy.pj.common.aspect;

import com.cy.pj.sys.service.SysLogService;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysLogAspect {
    private Logger log = LoggerFactory.getLogger(SysLogAspect.class);
    @Autowired
    private SysLogService sysLogService;

}
