package com.cy.pj.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class Activity {
    private Long id;
    private String title;
    private String category;
    //此注解用于描述或set方法,告诉springmvc按指定格式接收用户端数据
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date endTime;
    private String remark;
    private Integer state;
    private Date createdTime;
    private String createdUser;//有登陆模块的话,是登录用户

}