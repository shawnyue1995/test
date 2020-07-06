package com.cy.emp.controller;

import com.cy.emp.pojo.Emp;
import com.cy.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp/")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("findById")
    public String findById(Integer id,Model model){
        List<Emp> list=empService.findById(id);
        model.addAttribute("list",list);
        return "empUpdate.html";
    }

    @RequestMapping("empUpdate")
    public String update(Emp emp){
        empService.update(emp);
        System.out.println(emp);
        return "redirect:findAll";
    }
    @RequestMapping("insert")
    public  String insert(Emp emp){
        empService.insert(emp);
        return "redirect:findAll";
    }

    @RequestMapping("deleteById")
    public String deleteById(Integer id){
        empService.deleteById(id);
        return "redirect:findAll";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Emp> list =empService.findAll();
        model.addAttribute("list",list);
        return "emp";
    }
}
