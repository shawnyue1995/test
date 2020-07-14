package com.cy.pj.common.web;

import com.cy.pj.common.pojo.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ControllerAdvice 此注解描述的类，spring mvc 会认为他是一个控制层全局异常处理对象
 */
//@ControllerAdvice
@RestControllerAdvice//RestControllerAdvice注解相当于ControllerAdvice+ResponseBody

public class GlobalExceptionHandler {
    //JDK中自带的日志API
    @ExceptionHandler(RuntimeException.class)
    /**
     * @ExceptionHandler 此注解描述的方法为异常处理方法(不是我们定的)
     * 此注解中定义的异常类型为这个方法可以处理的异常类型，它可以处理此异常以及异常类型的子类类型的异常
     */
    //@ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        e.printStackTrace();//也可以写日志异常信息
        return new JsonResult(e);//封装
    }
}
