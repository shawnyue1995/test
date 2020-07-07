package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    static Map<String, Object> database = new HashMap<>();

    static {
        database.put("A", "100");
        database.put("B", "200");

    }

    @RequestMapping("doAjaxGetRequest")
    @ResponseBody/*将响应的内容以串的形式返回*/
    public String doAjaxGetRequest(String key) {
        return "query data by key " + key;
    }

    @RequestMapping("doAjaxPostRequest")
    @ResponseBody/*将响应的内容以串的形式返回*/
    public String doAjaxPostRequest(String key, String value) {
        return "save date[" + key + "," + value + "]";
    }

}
