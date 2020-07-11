package com.cy.pj.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 基于此对象封装业务数据执行结果
 * <p>
 * 在Java语言中,可以简单将内存中的对象分为两大类:
 * 1)存储数据的对象(设计的关键在属性上)-典型的POJO对象(VO,BO,DO)
 * 2)执行业务的对象(设计的关键在方法上)-典型的controller,service,dao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObject<T> implements Serializable {//pojo中的bo对象
    private static final long serialVersionUID = -5449885628893475693L;
    /**
     * 当前页的页码值
     */
    private Integer pageCurrent = 1;
    /**
     * 页面大小
     */
    private Integer pageSize = 3;
    /**
     * 总行数(通过查询获得)
     */
    private Integer rowCount = 0;
    /**
     * 总页数(通过计算获得)
     */
    private Integer pageCount = 0;
    /**
     * 当前页记录,list集合中的T由PageObject类上的定义的泛型决定
     */
    private List<T> records;

    public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.records = records;
/*        this.pageCount=this.rowCount/this.pageSize;
        if (this.rowCount/pageSize!=0){
            pageCount++;
        }*/
        this.pageCount = (rowCount - 1) / pageSize + 1;
    }
}
