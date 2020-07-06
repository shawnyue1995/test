package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {
    @Autowired//规则:先基于类型查找对象进行注入,加入类型有多个,在基于属性名字进行注入
    @Qualifier("softCache")//配合@Autowired注解使用,按bean名字进行值注入
    private Cache cache;

    @Test
    void testCache() {
        System.out.println(cache);
    }
}
