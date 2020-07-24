package com.cy.java.oop;

public class LogAspect implements Aspect{

    public void before(){
        System.out.println("start:"+System.currentTimeMillis());
    }
    public void after(){
        System.out.println("end:"+System.currentTimeMillis());
    }
}
