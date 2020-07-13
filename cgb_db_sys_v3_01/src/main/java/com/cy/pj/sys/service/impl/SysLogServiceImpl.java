package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.PageObject;
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
    public void saveObject(SysLog entity) {
        sysLogDao.insertObjects(entity);
    }

    @Override
    public int deleteObjects(Integer... ids) {
        //1.判定参数合法性
        if (ids == null || ids.length == 0) throw new IllegalArgumentException("请选择一个");
        //2.执行删除操作
        int rows = sysLogDao.deleteObjects(ids);
        //4.对结果进行验证
        if (rows == 0) throw new ServiceException("记录可能已经不存在");
        //5.返回结果
        return rows;
    }

    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        /**
         * 1.验证参数的合法性
         * 1.1验证pageCurrent的合法性
         * 不合法抛出IllegalArgumentException异常
         */
        if (pageCurrent == null || pageCurrent < 1)
            throw new IllegalArgumentException("当前页码不正确");
        /**
         * 2.基于条件查询总记录数
         * 2.1)执行查询
         */
        int rowCount = sysLogDao.getRowCount(username);
        /**
         * 2.2)验证查询结果,加入结果为0不再执行如下操作
         */
        if (rowCount == 0)
            //为了对业务中的信息进行更好的反馈和定位，通常会在项目中自定义异常
            //throw new RuntimeException("系统没有查到对应记录");尽量避免抛出RuntimeException
            throw new ServiceException("系统没有查到对应记录");
        /**
         * 3.基于pageCurrent查询当前页记录(pageSize定义为2)
         * 3.1)定义pageSize-页面大小
         */
        int pageSize = 3;//每页最多显示多少条记录
        /**
         * 3.2)计算startIndex
         */

        int startIndex = (pageCurrent - 1) * pageSize;
        /**
         * 3.3)执行当前数据的查询操作
         */
        List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
        /**
         * 4.对分页信息以及当前页记录进行封装
         * 4.1)构建pageObject对象
         */
        PageObject<SysLog> pageObject = new PageObject<>();
        /**
         * 4.2)封装数据
         */
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRecords(records);
        /**
         * 计算分页的方法一：
         * int pageCount=rowCount/pageSize;
         * if(rowCount%pageSize!=0)pageCount++;
         *
         * 计算总页数的方法二：
         */
        pageObject.setPageCount((rowCount - 1) / pageSize + 1);
        //5.返回封装结果
        return pageObject;
    }
}
