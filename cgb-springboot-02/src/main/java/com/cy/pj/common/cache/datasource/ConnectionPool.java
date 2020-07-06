package com.cy.pj.common.cache.datasource;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 假设如下对象为一个池对象
 * Spring 管理bean对象，会为bean赋予什么特性？这些特性有什么好处？
 * 1)延迟加载(按需加载，懒加载)特性-暂缓对象的创建，何时需要何时创建？
 * a)优点：可以优化资源的使用。
 * b)缺点：用时在创建可能会导致响应速度降低。
 * c)场景：资源有限，大对象，稀少用能懒加载就懒加载。
 * d)实现：在需要懒加的对象类型上使用@Lazy注解进行描述
 * <p>
 * 2)作用域(Spring框架为对象提供的作用范围，对象的生命周期只能在指定范围有效)
 * a)优点：让对象在有效范围发挥作用，尽量控制对象的创建和销毁以保证对象的高效，低耗的运行。
 * b)缺点：框架底层设计难度会加大，应用不熟练会导致作用域冲突。
 * c)场景：不同业务,作用域的设计也不同？(例如 对象在整个项目中应用非常频繁可以考虑单例作用域。)
 * d)实现：在需要设定作用域的类上使用@Scope注解进行描述。
 * d.1)@Scope("singleton") 单例作用域，此作用域的对象在这个内存只有一份，通过
 * 共享设计(bean池)，实现对象的可重用性。此对象何时创建由懒加载(Lazy)特性
 * 设计决定，是否可以被销毁由spring框架决定(一般是在容器销毁时销毁)。适合
 * 频度应用比较高的对象。
 * <p>
 * d.2)@Scope("prototype") 多例作用域，此作用域的对象在需要时创建(与懒加载特性无关)，
 * 每次从容器获取都是一个新的对象，且这些对象spring框架不负责销毁。适合应用频度比
 * 较低的对象。
 * <p>
 * 3)生命周期方法？(每个对象都有生命周期，但不见得每个对象都会设置生命周期方法)
 * a)如何理解生命周期方法？生命周期方法是在对象生命周期过程中要执行的一些方法。
 * b)设计生命周期方法的目的？对象生命周期的不同阶段执行不同业务(例如servlet 中init,service,destory)
 * c)Spring如何设计Bean对象生命周期方法？spring框架中使用相关注解对象对生命周期方法进行描述。
 */
@Component
@Lazy
//@Scope("singleton")//默认,没有指定scope的时候默认就是singleton作用域
@Scope("prototype")
public class ConnectionPool {
    public ConnectionPool() {
        System.out.println("ConnectionPool");
    }

    @PostConstruct//此注解描述生命周期初始化方法,在构造方法执行之后执行,用于实现一些资源的初始化
    public void init() {
        System.out.println("init");
    }

    @PreDestroy//此注解描述生命周期销毁方法,在对象销毁时执行
    public void destory() {
        System.out.println("destory");
    }
}
//程序的终极目标:高效,低耗
