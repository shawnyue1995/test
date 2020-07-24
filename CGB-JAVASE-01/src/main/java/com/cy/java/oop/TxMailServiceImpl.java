package com.cy.java.oop;

public class TxMailServiceImpl implements MailService {
    //目标对象接口
    private MailService mailService;
    //封装拓展业务对象
    private Aspect aspect;
    public TxMailServiceImpl(MailService mailService,Aspect aspect) {
        this.mailService = mailService;
        this.aspect=aspect;
    }


    @Override
    public void send(String msg) {
        aspect.before();
        mailService.send(msg);
        aspect.after();
    }
}
