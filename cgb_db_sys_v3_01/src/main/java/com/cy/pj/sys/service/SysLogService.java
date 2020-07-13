package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.pojo.SysLog;

public interface SysLogService {

    /**
     * 执行日志新增操作
     */
    void saveObject(SysLog entity);

    /**
     * 基于记录id执行日志删除操作
     *
     * @param ids
     * @return
     */
    int deleteObjects(Integer... ids);

    /**
     * 基于条件进行分页查询
     *
     * @param username    查询条件
     * @param pageCurrent
     * @return
     */
    PageObject<SysLog> findPageObjects(String username, Integer pageCurrent);
}
