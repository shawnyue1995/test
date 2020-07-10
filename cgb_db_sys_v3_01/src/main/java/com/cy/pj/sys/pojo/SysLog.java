package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 此对象主要用来封装数据库提取的数据或者想数据库写入的数据
 * 此对象各种的属性建议和表中字段有对应的映射关系(名字,类型)
 * 建议:所有用于封装数据的对象都建议实现序列化接口(Serializable)
 * 1)序列化:将对象转换为字节的过程称之为对象的序列化
 * 2)反序列化:将自己饿转换为对象的过程称之为反序列化
 * 3)应用场景:对对象进行缓存,将对象进行钝化(写入文件),将对象通过网络进行传输
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = -1592163223057343412L;
    //对象在序列化和反序列化的时候回基于此id进行数据处理
    //将对象序列化时会将这个id作为版本写入到字节中
    //将字节反序列化时会从字节中提取版本id然后和类中的版本id进行对比,一致则进行反序列化
    private Integer id;
    //用户名
    private String username;
    //用户操作
    private String operation;
    //请求方法
    private String method;
    //请求参数
    private String params;
    //执行时长(毫秒)
    private Long time;
    //IP地址
    private String ip;
    //创建时间
    private Date createdTime;
}
