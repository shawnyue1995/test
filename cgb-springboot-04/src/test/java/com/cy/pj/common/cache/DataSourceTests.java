package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 通过此小节的学习
 * 1)我们你应该掌握何为规范的实现,何为标准的实现
 * a)java.sql.DataSource为标准,HikariDataSource为标准的实现
 * b)java.sql.Driver为标准,com.mysql.jdbc.Driver为标准实现
 * 2)掌握springboot项目中hikariCP连接池配置方式
 * a)添加依赖
 * b)连接配置
 * c)获取数据源对象,基于此对象,获取连接
 * 3)掌握池化思想应用的目的(优势,劣势)
 *
 */
@SpringBootTest
public class DataSourceTests {
    /**
     * 请问此变量指向的对象的类型是什么?com.zaxxer.hikari.HikariDataSource)
     * 请问你是如何知道DataSource变量指向的对象的具体类型的?
     * 1.基于实例的自解码对象获取
     * 2.基于断点调试获取其具体类型
     */
    @Autowired
    private DataSource dataSource;
    @Test
    void testGetConnection() throws SQLException {
        //获取对象的类型的类全名(com.zaxxer.hikari.HikariDataSource) //springboot 自动配置
        System.out.println(dataSource.getClass().getName());
        //请问这个域数据库的连接是通过jdbc中的哪个API对象获取的?
        //java.sql.Driver接口的实现类对象
        long t1=System.currentTimeMillis();
        System.out.println(dataSource.getConnection());
        long t2=System.currentTimeMillis();
        System.out.println("t2-t1="+(t2-t1));
        System.out.println(dataSource.getConnection());
        long t3=System.currentTimeMillis();
        System.out.println("t3-t2="+(t3-t2));
    }
}

