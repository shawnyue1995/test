package com.cy.pj.sys.service.ServiceImpl;

import com.cy.pj.sys.common.pojo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageObject<SysLog> findObjects(String name, Integer pageCurrent) {
        if (pageCurrent == null || pageCurrent < 1) throw new IllegalArgumentException("当前页码不正确");
        int rowCount = sysLogDao.getRowCount(name);
        if (rowCount == 0) throw new IllegalArgumentException("系统没有查到对应的记录");
        int pageSize = 2;
        int startIndex = (pageCurrent - 1) * pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(name, startIndex, pageSize);
        PageObject<SysLog> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount - 1) / pageSize);
        return pageObject;
    }
}
