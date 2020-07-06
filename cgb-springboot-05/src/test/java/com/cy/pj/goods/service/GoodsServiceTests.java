package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsServiceTests {
    @Autowired
    private GoodsService goodsService;
    @Test
    public void testFindGoods(){
        List<Goods> list=goodsService.findGoods();
        list=goodsService.findGoods();
        //System.out.println(list);//toString()
        for (Goods g:list) {
            System.out.println(g);//toString()
        }
    }
}
