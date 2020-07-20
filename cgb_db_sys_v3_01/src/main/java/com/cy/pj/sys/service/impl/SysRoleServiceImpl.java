package com.cy.pj.sys.service.impl;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.web.AssertUtil;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public int updateObject(SysRole entity, Integer[] menuIds) {
        AssertUtil.isArgumentValid(entity == null, "更新的对象不能为空");
        AssertUtil.isArgumentValid(entity.getId() == null, "id值不能为空");
        AssertUtil.isArgumentValid(StringUtils.isEmpty(entity.getName()), "角色名不能为空");
        AssertUtil.isArgumentValid(menuIds == null || menuIds.length == 0, "必须为角色指定一个权限");
        int rows = sysRoleDao.updateObject(entity);
        AssertUtil.isResultValid(rows == 0, "对象可能已经不存在");
        sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
        sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
        return rows;
    }

    @Override
    public SysRoleMenu findObjectById(Integer id) {
        AssertUtil.isArgumentValid(id == null || id < 0, "id的值不合法");
        SysRoleMenu result = sysRoleDao.findObjectById(id);
        AssertUtil.isResultValid(result == null, "此记录已经不存在");
        return result;
    }

    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer PageCurrent) {
        //1.参数校验
        //if (PageCurrent==null || PageCurrent<1) throw new IllegalArgumentException("当前页码值无效");
        AssertUtil.isArgumentValid(PageCurrent == null || PageCurrent < 1, "页码值不正确");
        //2.基于条件查询总记录数并校验
        int rowCount = sysRoleDao.getRowCount(name);
        //if (rowCount==0) throw new IllegalArgumentException("没有找到对应的记录");
        AssertUtil.isResultValid(rowCount == 0, ",没有对应的记录");
        //3.查询当前页要呈现的角色记录
        int pageSize = 2;
        int startIndex = (PageCurrent - 1) * pageSize;
        List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
        //4.封装查询结果并返回
        return new PageObject<>(PageCurrent, pageSize, rowCount, records);
    }

    @Override
    public int deleteObject(Integer id) {
        //1.验证数据的合法性
        AssertUtil.isArgumentValid(id == null || id < 1, "参数无效");
        //2.基于id删除关系数据
        sysRoleMenuDao.deleteObjectsByRoleId(id);
        sysUserRoleDao.deleteObjectsByRoleId(id);
        //3.删除角色自身
        int rows = sysRoleDao.deleteObject(id);
        AssertUtil.isResultValid(rows == 0, "此记录可能已经不存在");
        //4.封装查询结果并返回
        return rows;
    }

    @Override
    public int saveObject(SysRole entity, Integer[] menuIds) {
        AssertUtil.isArgumentValid(entity == null, "保存对象不能为空");
        AssertUtil.isArgumentValid(StringUtils.isEmpty(entity.getName()), "角色名不允许为空");
        AssertUtil.isArgumentValid(menuIds == null || menuIds.length == 0, "必须为角色分配权限");
        int rows = sysRoleDao.insertObject(entity);
        sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
        return rows;
    }

    @Override
    public List<CheckBox> findObjects() {
        return sysRoleDao.findObjects();
    }
}

