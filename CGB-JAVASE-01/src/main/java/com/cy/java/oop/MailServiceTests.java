package com.cy.java.oop;

public class  MailServiceTests {
    public static void main(String[] args) {
        //doCglibProxy();
        doJdkProxy();
    }
    //JDK代理方式的AOP结构分析
    private static void doJdkProxy(){
        //目标对象
        MailService target=new MailServiceImpl();
        //扩展业务（切面对象）
        TransactionAspect aspect=new TransactionAspect();
        //JDK代理对象（模拟）
       MailService jdkProxy=new TxMailServiceImpl(target,aspect);
       jdkProxy.send("hello cgb 2004");
    }
    private static void doCglibProxy(){//CGLIB代理方式的AOP结构分析
        //MailService mailService=new MailServiceImpl();
        //扩展业务对象
        LogAspect logAspect=new LogAspect();
        //CGLIB代理对象
        MailService mailService=new LogMailServiceImpl(logAspect);
        //直接修改方法内部代码实现功能拓展，这种方法违背了OCP原则（开闭）
        mailService.send("hello cgb2004");
    }
}
