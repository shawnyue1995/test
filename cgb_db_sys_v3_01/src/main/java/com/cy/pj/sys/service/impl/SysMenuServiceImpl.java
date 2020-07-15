package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public int updateObject(SysMenu entity) {
        if (entity == null) throw new ServiceException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getName())) throw new ServiceException("菜单名不能为空");
        int rows;
        try {
            rows = sysMenuDao.updateObject(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        return rows;
    }

    @Override
    public int saveObject(SysMenu entity) {
        //1、合法验证
        if (entity == null) throw new ServiceException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getName())) throw new ServiceException("菜单名不能为空");
        //2、保存数据
        int rows;
        try {
            rows = sysMenuDao.insertObject(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        return rows;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        return sysMenuDao.findZtreeMenuNodes();
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String, Object>> list = sysMenuDao.findObjects();

        if (list == null || list.size() == 0) throw new ServiceException("没有对应的菜单信息");
        return list;
    }


    @Override
    public int deleteObject(Integer id) {
        //1.验证数据的合法性
        if (id == null || id <= 0) throw new IllegalArgumentException("参数值无效");
        //2.统计菜单子元素并校验
        int count = sysMenuDao.getChildCount(id);
        if (count > 0) throw new ServiceException("请先删除子菜单");
        //3.删除菜单关系数据
        sysRoleMenuDao.deleteObjectsByMenuId(id);
        //4.删除菜单元素
        int rows = sysMenuDao.deleteObject(id);
        if (rows == 0) throw new ServiceException("此菜单可以已经不存在");
        //5.返回结果集
        return rows;
    }
}
