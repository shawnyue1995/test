package com.cy.pj.goods.service.impl;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 商品业务层对象,负责业务逻辑处理
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findGoods() {
        Long start=System.currentTimeMillis();
        List<Goods> list=goodsDao.findObjects();
        long end=System.currentTimeMillis();
        System.out.println("query time:"+(end-start));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        int rows=goodsDao.deleteById(id);
    }

    @Override
    public int insert(Goods entity) {
        int rows=goodsDao.insert(entity);
        return rows;
    }

}
