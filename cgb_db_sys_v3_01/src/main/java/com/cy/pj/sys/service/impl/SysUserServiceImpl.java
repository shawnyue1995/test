package com.cy.pj.sys.service.impl;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.web.AssertUtil;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.pojo.SysUserDept;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageObject<SysUserDept> findPageObjects(String username, Integer pageCurrent) {
        //1.对参数进行校验
        AssertUtil.isArgumentValid(pageCurrent == null || pageCurrent < 1, "当前页码值无效");
        //2.查询总记录数并进行校验
        int rowCount = sysUserDao.getRowCount(username);
        AssertUtil.isArgumentValid(rowCount == 0, "没有找到对应记录");
        //3.查询当前页码值
        int pageSize = 2;
        int startIndex = (pageCurrent - 1) * pageSize;
        List<SysUserDept> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
        return new PageObject<>(pageCurrent, pageSize, rowCount, records);
    }

    @Override
    public int validById(Integer id, Integer valid) {
        AssertUtil.isArgumentValid(id == null || id <= 0, "参数不合法，id=" + id);
        AssertUtil.isArgumentValid(valid != 1 && valid != 0, "参数不合法，valid=" + valid);
        /*        AssertUtil.isArgumentValid(StringUtils.isEmpty(modifiedUser),"修改用户不能为空");*/
        int rows = sysUserDao.validById(id, valid, "admin");
        AssertUtil.isResultValid(rows == 0, "此记录可能已经不存在");
        return rows;
    }
}
