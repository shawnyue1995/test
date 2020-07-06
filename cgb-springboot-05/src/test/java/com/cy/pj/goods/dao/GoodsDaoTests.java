package com.cy.pj.goods.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsDaoTests {
    //has a
    @Autowired
    public GoodsDao goodsDao;//请问这个引用的指向的对象是谁?
    @Test
    void testDeleteById(){
        /**
         * 映射语句执行过程:
         * 1.基于dao接口的类全名找到映射文件对应的命名空间
         * 2.找到映射文件中与调用方法名字相同的元素id
         * 3.基于元素id找到对应的sql
         * 4.基于sql与数据库进行会话
         */
        int rows=goodsDao.deleteById(10);//请问此操作需要连接吗?从哪里来?
        System.out.println("影响行数:"+rows);
    }
    @Test
    void testDeleteObjects(){
        /**
         *
         *
         * 执行goodsDao.deleteObjects方法时
         * 系统会1)基于接口类全名找到namespace对应的映射文件
         */
        int rows=goodsDao.deleteObjects(17,18);
        System.out.println(rows);
    }
}
