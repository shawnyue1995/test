package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysLogDaoTest {

    @Autowired
    private SysLogDao sysLogDao;

    @Test
    void testGetRowCount() {
        int rowCount = sysLogDao.getRowCount("admin");
        System.out.println("rowCount=" + rowCount);
    }

    @Test
    void testFindPageObjects() {
        List<SysLog> list = sysLogDao.findPageObjects("admin", 0, 3);
        for (SysLog log : list) {
            System.out.println(log);
        }
    }
}
