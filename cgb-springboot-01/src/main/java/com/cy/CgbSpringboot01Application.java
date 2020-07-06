package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 由此注解(@SpringBootApplication)描述的类为springboot项目的启动入口类
 * 记住:
 * 1)springboot项目的启动入口类只能有一个
 * 2)springboot项目的启动入口类需要使用@SpringBootApplication注解进行描述
 * FAQ?
 * 1)这个类在启动时会做那些事?
 * a)加载类(将类的信息从磁盘读到内存):线程+IO
 * b)创建字节码对象(其类型为Class类型)用于存储类的字节码信息
 * c)基于字节码对象,获取类上的注解信息,判定此类是否要交给spring管理
 * d)假如是交给spring管理的对象,spring框架会创建其对象然后赋予其特性
 * e)基于配置文件以(例如:application.properties)及springboot提供的自动配置对对象进行初始化应用
 * 2)如何验证类在启动时加载了哪些类?(借助JVM参数进行分析)
 * a)类加载过程分析参数:-XX:+TraceClassLoading
 * 3)在springboot中我们自己的java业务代码写到哪里?如何交给spring管理
 * a)所有的业务代码写到src/main/java目录中启动类所在的包或者子包中
 * b)将这些类使用特定注解进行描述(@Commpent,@Service,@Controller...)
 * 4)在Springboot中我们自己的Java业务测试代码写到哪里?有什么特点
 * a)所有测试代码写到src/test/java目录中启动类所在包或子包中
 * b)所有测试类使用@SpringBootTest注解进行描述
 * c)所有测试方法上的Test注解使用org.junit.jupiter.api包下的
 */
@SpringBootApplication
public class CgbSpringboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(CgbSpringboot01Application.class, args);
    }

}
