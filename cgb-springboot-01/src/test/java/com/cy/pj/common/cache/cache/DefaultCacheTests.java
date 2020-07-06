package com.cy.pj.common.cache.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Autowired 注解描述属性时, 用于告诉spring框架, 要为此属性注入一个值
 * has a
 */
@SpringBootTest
public class DefaultCacheTests {
    @Autowired
    private DefaultCache defaultCache;

    @Test
    void DefaulttestCache() {
        System.out.println(defaultCache);
    }
}
/**
 * 分析:
 * 1.假如在18行输出defaultCache的值为null,可能的原因是什么?
 * 1)defaultCache属性没有使用@Autowired相关描述?(spring不认为这个属性是相关注解)
 * 2)单元测试类没有使用!SpringBootTest注解描述
 * 3)Test注解类所在包检测是否有问题,测试类的位置(例如包结构)是否有问题?
 * <p>
 * 2.假如DefaultCache的单元测试中出现NoSuchBeanDefinitionException异常,
 * 其类型为com.cy.pj.common.cache.DefaultCache这个bean对象找不到,请问原因是什么?
 * 1)DefaultCache这个类所在的包不在启动类所在包或子包中
 * 2)DefaultCache没有使用spring指定的注解进行描述
 */