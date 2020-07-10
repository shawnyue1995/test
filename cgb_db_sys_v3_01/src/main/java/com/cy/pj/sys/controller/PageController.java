package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目中所有页面的处理,计划都放在这个controller中
 */
@RequestMapping("/")
@Controller
public class PageController {
    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
    }//首页页面

    /**
     * 基于此方法返回日志列表页面(记住此页面不是一个完整页面)
     *
     * @return
     */
    @RequestMapping("log/log_list")
    public String doLoginUI() {
        return "sys/log_list";
    }

    /**
     * 基于此方法返回分页页面元素
     *
     * @return
     */
    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }
}
