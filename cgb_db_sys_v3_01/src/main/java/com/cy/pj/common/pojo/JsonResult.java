package com.cy.pj.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基于此对象封装服务端响应到客户端的数据，这个数据包含：
 * 1）状态码(表示这个响应结果是正确的还是错误的)
 * 2)状态信息（状态码对象的状态信息）
 * 3）正常的响应数据（例如一个查询结果）
 * POJO：（VO-View Object 封装了表现层要呈现的数据）
 */
@Data
@NoArgsConstructor
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 2080943344863436345L;
    /**
     * 状态码
     */
    private int state = 1;//1表示SUCCESS,0表示ERROW
    /**
     * 状态信息
     */
    private String message = "ok";
    /**
     * 正确的响应数据
     */
    private Object data;

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable e) {//Throwable是所有异常类的父类
        this.state = 0;
        this.message = e.getMessage();
    }
}
