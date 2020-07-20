package com.cy.pj.sys.controller;

import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    //@RequestMapping("doFindPageObjects")
    @GetMapping("doFindPageObjects")//服务端只能处理get请求
    public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
        return new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        return new JsonResult("delete ok");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.saveObject(entity, menuIds);
        return new JsonResult("save OK");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id) {
        return new JsonResult(sysRoleService.findObjectById(id));
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.updateObject(entity, menuIds);
        return new JsonResult("update ok");
    }

    /**
     * 在角色控制层查询角色id，name
     *
     * @return
     */
    @RequestMapping("doFindRoles")
    public JsonResult doFindRoles() {
        return new JsonResult(sysRoleService.findObjects());
    }
}