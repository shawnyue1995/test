package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findGoods();

    void deleteById(Integer id);

    int insert(Goods entity);
}
