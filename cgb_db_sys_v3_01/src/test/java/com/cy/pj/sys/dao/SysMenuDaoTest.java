package com.cy.pj.sys.dao;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

//@Slf4j
@SpringBootTest
public class SysMenuDaoTest {
    //初始化日志对象，假如使用lombok中的@slf4j，底层会自动帮我们生成如下语句
    private static final Logger log = //接口默认指向的实现类为logback
            LoggerFactory.getLogger(SysMenuDaoTest.class);

    @Autowired
    private SysMenuDao sysMenuDao;

    @Test
    void testFindObjects() {
        List<Map<String, Object>> list = sysMenuDao.findObjects();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
        //list.forEach(item->System.out.println(item));//JDK1.8新特新
        //list.forEach(System.out::println);
    }
}
