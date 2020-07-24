package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class SysTimeAspect {
    @Pointcut("bean(sysRoleServiceImpl)")
    public void doTimeAspect() {
    }

    @Before("doTimeAspect()")
    public void doBefore() {
        System.out.println("@Before");
    }

    @After("doTimeAspect()")
    public void doAfter() {
        System.out.println("@After");
    }

    @AfterReturning("doTimeAspect()")
    public void doAfterReturning() {
        System.out.println("@AfterReturning");
    }

    /**
     * 核心业务出现异常时执行说明：假如有after，先执行after,再执行Throwing
     */
    @AfterThrowing("doTimeAspect()")
    public void doAfterThrowing() {
        System.out.println("@AfterThrowing");
    }

    @Around("doTimeAspect()")
    public Object doAround(ProceedingJoinPoint jp)
            throws Throwable {
        System.out.println("@Around.before");
        try {
            Object result = jp.proceed();//执行本类@Before（假如有）,后续其他切面方法（假如有），最后目标方法
            System.out.println("@Around.after");
            return result;
        } catch (Throwable e) {
            System.out.println("@Around.exception");
            throw e;
        }
    }
}
