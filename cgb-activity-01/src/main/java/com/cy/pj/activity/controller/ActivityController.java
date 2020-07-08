package com.cy.pj.activity.controller;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activity/doActivityUI")
    public String doActivityUI() {
        return "activity";
    }

    @RequestMapping("/activity/doSaveObject")
    @ResponseBody
    public String doSaveObject(Activity entity) {
        activityService.saveObject(entity);
        return "save ok";
    }

    @RequestMapping("/activity/doDeleteById")
    @ResponseBody
    public String deleteById(Long id) {
        activityService.doDeleteById(id);
        return "delete ok";
    }

    @RequestMapping("/activity/doFindActivitys")
    @ResponseBody  //此注解用于告诉spring mvc要对此方法的返回结果进行转换处理
    //假如方法返回值为对象(不包含字符串，直接量),
    //spring mvc可以将其转换为json格式的字符串
    public List<Activity> doFindActivitys() {
        return activityService.findActivitys();
    }//Spring MVC框架底层默认会使用jackson API将对象转换为json格式字符串。
}