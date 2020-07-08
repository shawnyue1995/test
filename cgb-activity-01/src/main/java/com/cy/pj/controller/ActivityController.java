package com.cy.pj.controller;

import com.cy.pj.pojo.Activity;
import com.cy.pj.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping("findById")
    public String findById(Long id, Model model) {
        Activity activity = activityService.findById(id);
        model.addAttribute("activity", activity);
        return "activity-update";
    }

    @RequestMapping("update")
    public String update(Activity entity) {
        activityService.update(entity);
        System.out.println(entity);
        return "redirect:findAll";
    }

    @RequestMapping("doSaveObject")
    public String doSaveObject(Activity entity) {
        System.out.println("controller.entity=" + entity);
        activityService.saveObject(entity);
        return "redirect:findAll";
    }

    @RequestMapping("activity-add.html")
    public String doActivityAddUI() {
        return "activity-add";
    }

    @RequestMapping("deleteById")
    public String deleteById(Long id) {
        activityService.deleteById(id);
        return "redirect:findAll";
    }

    @RequestMapping("doActivityuI")
    public String doActivityUI() {
        return "activity";
    }

    @RequestMapping("findAll")
    @ResponseBody//此注解用来告诉springmvc要对此方法的返回结果进行转换处理
    //假如方法返回值为对象(不包含字符串,直接量)
    //springmvc可以将其转换为jason格式的字符串
    public List<Activity> findAll() {
        return activityService.findAll();

    }
}
