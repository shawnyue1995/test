package com.cy.pj.sys.controller;

import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log/")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindObjects(String username, Integer pageCurrent) {
        PageObject<SysLog> pageObject =
                sysLogService.findPageObjects(username, pageCurrent);
        //控制层对业务数据再次封装
        //方法1
        return new JsonResult(pageObject);//此位置封装为业务的正常数据
    }
}
