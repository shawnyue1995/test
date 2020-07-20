package com.cy.pj.sys.service.impl;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.web.AssertUtil;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserDept;
import com.cy.pj.sys.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public Map<String, Object> findObjectById(Integer id) {
        log.info("start {}", System.currentTimeMillis());
        //1.参数校验
        AssertUtil.isArgumentValid(id == null || id < 1, "参数无效");
        //2.基于用户id查询用户以及用户对应的部门信息
        SysUserDept user = sysUserDao.findById(id);
        AssertUtil.isResultValid(user == null, "对象可能已经不存在了");
        //3.基于用户id查询用户对应的角色信息
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
        //4.封装结果并返回
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("roleIds", roleIds);
        log.info("end {}", System.currentTimeMillis());
        return map;
    }

    @Override
    public int updateObject(SysUser entity, Integer[] roleIds) {
        //1.参数校验
        AssertUtil.isArgumentValid(entity == null, "保存对象不允许为空");
        AssertUtil.isArgumentValid(
                StringUtils.isEmpty(entity.getUsername()), "用户名不能为空");
        AssertUtil.isArgumentValid(roleIds == null || roleIds.length == 0, "必须为用户指定角色");
        //....
        //2.更新用户自身信息
        int rows = sysUserDao.updateObject(entity);
        //3.保存用户角色关系数据
        sysUserRoleDao.deleteObjectsByUserId(entity.getId());
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        return rows;
    }

    @Override
    public int saveObject(SysUser entity, Integer[] roleIds) {
        //1.参数校验
        AssertUtil.isArgumentValid(entity == null, "保存对象不允许为空");
        AssertUtil.isArgumentValid(
                StringUtils.isEmpty(entity.getUsername()), "用户名不能为空");
        AssertUtil.isArgumentValid(
                StringUtils.isEmpty(entity.getPassword()), "密码不能为空");
        AssertUtil.isArgumentValid(roleIds == null || roleIds.length == 0, "必须为用户指定角色");
        //....
        //2.保存用户自身信息
        //2.1密码加密(本次算法使用md5加密->特点：不可逆，相同内容加密结果一定相同)
        String salt = UUID.randomUUID().toString();//让随机字符串作为加密盐
        System.out.println("salt=" + salt);
        //spring框架内置的DigestUtils工具类实现其加密
        //String hashedPwd=DigestUtils.md5DigestAsHex((salt+entity.getPassword()).getBytes());
        //基于Shiro框架中的api实现盐值加密
        SimpleHash simpleHash = new SimpleHash(
                "MD5",//algorithmName 算法名称
                entity.getPassword(),
                salt,
                1);//1表示加密次数，加密次数越多安全就越好。
        String hashedPwd = simpleHash.toHex();//将加密结果转换为16进制
        System.out.println("hashedPwd=" + hashedPwd);
        entity.setSalt(salt);
        entity.setPassword(hashedPwd);
        //2.2保存用户信息
        int rows = sysUserDao.insertObject(entity);
        //3.保存用户角色关系数据
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        return rows;
    }

    @Override
    public int validById(Integer id, Integer valid) {
        //1.参数校验
        AssertUtil.isArgumentValid(id == null || id < 1, "id值无效");
        AssertUtil.isArgumentValid(valid == null || (valid != 0 && valid != 1), "状态值不正确");
        //2.修改状态
        int rows = sysUserDao.validById(id, valid, "admin");//将来admin为登陆用户，现在就是一个假数据
        //3.验证结果
        AssertUtil.isResultValid(rows == 0, "记录可能已经不存在");
        return 0;
    }


    @Override
    public PageObject<SysUserDept> findPageObjects(String username,
                                                   Integer pageCurrent) {
        //1.参数校验
        AssertUtil.isArgumentValid(pageCurrent == null || pageCurrent < 1, "页码值不正确");
        //2.查询总记录数并校验
        int rowCount = sysUserDao.getRowCount(username);
        AssertUtil.isResultValid(rowCount == 0, "没有对应的记录");
        //3.查询当前页记录
        int pageSize = 3;
        int startIndex = (pageCurrent - 1) * pageSize;
        List<SysUserDept> records =
                sysUserDao.findPageObjects(username, startIndex, pageSize);
        //4.封装查询结果
        return new PageObject<>(rowCount, pageSize, pageCurrent, records);
    }

}
