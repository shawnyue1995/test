package com.cy.pj.sys.controller;

import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目中所有页面的处理,计划都放在这个controller中
 */
@RequestMapping("/")
@Controller
public class PageController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
    }//首页页面

    //rest 风格（一种架构风格）的url，其语法结构{变量名}{变量}
    //PathVariable注解用于修饰方法参数，可以从rest风格的url中获取和参数名对应的值
    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI) {
        return "sys/" + moduleUI;
    }


/*    @RequestMapping("menu/menu_list")
    public String doMenuUI(){
        return "sys/menu_list";
    }

     *//**
     * 基于此方法返回日志列表页面(记住此页面不是一个完整页面)
     * @return
     *//*
    @RequestMapping("log/log_list")
    public String doLoginUI() {
        return "sys/log_list";
    }*/

    /**
     * 基于此方法返回分页页面
     */
    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }
}
