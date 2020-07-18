package com.cy.pj.sys.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 6819201941632248521L;
    /**
     * 状态码
     */
    private int state = 1;//1表示SUCCESS,0表示ERROR
    /**
     * 状态信息
     */
    private String message = "ok";
    /**
     * 正确数据
     */
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable t) {
        this.state = 0;
        this.message = t.getMessage();
    }
}
