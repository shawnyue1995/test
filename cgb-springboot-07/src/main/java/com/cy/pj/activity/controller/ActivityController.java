package com.cy.pj.activity.controller;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping("findById")
    public String findById(Long id,Model model){
         Activity activity= activityService.findById(id);
        model.addAttribute("activity",activity);
        return "activity-update.html";
    }

    @RequestMapping("update")
    public String update(Activity entity){
        activityService.update(entity);
        System.out.println(entity);
        return "redirect:findAll.html";
    }

    @RequestMapping("doSaveObject")
    public String doSaveObject(Activity entity){
        System.out.println("controller.entity="+entity);
        activityService.saveObject(entity);
        return "redirect:findAll.html";
    }
    @RequestMapping("activity-add.html")
    public String doActivityAddUI(){
        return "activity-add";
    }

    @RequestMapping("deleteById")
    public String deleteById(Long id){
        activityService.deleteById(id);
        return "redirect:findAll.html";
    }

    @RequestMapping("findAll.html")
    public String findAll(Model model){
        List<Activity> list=activityService.findAll();
        model.addAttribute("list",list);
        return "activity";
    }
}
