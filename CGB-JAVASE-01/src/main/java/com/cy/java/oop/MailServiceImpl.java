package com.cy.java.oop;

/**
 * 目标业务对象，封装核心业务逻辑的处理
 */
public class MailServiceImpl implements MailService{
    @Override
    public void send(String msg) {
        //直接修改方法内部代码实现功能拓展，这种方法违背了OCP原则（开闭）
        System.out.println("start:"+System.currentTimeMillis());
        System.out.println("msg="+msg);
        System.out.println("end:"+System.currentTimeMillis());
    }
}
