package com.cy.pj.activity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 基于表设计构建pojo对象
 * create table tb_activity(
 * id bigint primary key auto_increment,
 * title varchar(100) not null,
 * category varchar(100) not null,
 * startTime datetime not null,
 * endTime datetime not null,
 * remark text,
 * state tinyint,
 * createdTime datetime not null,
 * createdUser varchar(100)
 * )engine=InnoDB;
 *
 * @author qilei
 */
//@Data
@Setter
@Getter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Activity {
    private Long id;
    private String title;
    private String category;
    //此注解用于描述属性或set方法，告诉spring mvc 按指定格式接收客户端数据
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")//应用场景对应set方法
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")//此注解用于描述或get方法
    private Date startTime;//java.util.Date

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    //将一个对象转换为json格式字符串时,底层会调用其get方法,然后基于@JsonFormat定义的日期格式进行转换
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "Asia/Shanghai")//应用场景对应get方法
    private Date endTime;
    private String remark;
    private Integer state;
    private Date createdTime;
    private String createdUser; //有登陆模块的话，是登陆用户

}