package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserDept;

import java.util.Map;

public interface SysUserService {

    Map<String, Object> findObjectById(Integer id);

    /**
     * 保存用户自身信息以及用户和角色的关系数据
     *
     * @param entity
     * @param roleIds
     * @return
     */
    int updateObject(SysUser entity, Integer[] roleIds);

    /**
     * 保存用户自身信息以及用户和角色的关系数据
     *
     * @param entity
     * @param roleIds
     * @return
     */
    int saveObject(SysUser entity, Integer[] roleIds);

    /**
     * 基于id修改用户状态
     *
     * @param id
     * @param valid
     * @return
     */
    int validById(Integer id, Integer valid);

    PageObject<SysUserDept> findPageObjects(String username, Integer pageCurrent);
}
