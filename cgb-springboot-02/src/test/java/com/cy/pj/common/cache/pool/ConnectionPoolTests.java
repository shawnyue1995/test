package com.cy.pj.common.cache.pool;


import com.cy.pj.common.cache.datasource.ConnectionPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConnectionPoolTests {
    @Autowired
    private ConnectionPool connectionPool01;
    @Autowired
    private ConnectionPool connectionPool02;

    @Test
    void testConnectionPool() {
        System.out.println(connectionPool01 == connectionPool02);
    }

}
