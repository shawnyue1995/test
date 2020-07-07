package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    @RequestMapping("doAjaxGetRequest")
    @ResponseBody/*将响应的内容以串的形式返回*/
    public String doAjaxGetRequest() {
        return "ajax get response result";
    }
}
