package com.cy.pj.activity.pojo;

import java.util.Date;

public class Activity {
    private Long id;
    private String title;
    private String category;
    private Date startTime;
    private Date endTime;
    private String remark;
    private Integer state;
    private Date createdTime;
    private String createdUser;//有登陆模块的话,是登录用户

}
