package com.cy.java.oop;

public class TransactionAspect implements Aspect{
    @Override
    public void before() {
        System.out.println("开启事务");
    }

    @Override
    public void after() {
        System.out.println("提交事务");
    }
}
