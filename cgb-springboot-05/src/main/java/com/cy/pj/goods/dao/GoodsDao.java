package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Mapper是由Mybatis框架中定义的一个描述数据层接口对象的注解(所有的注解起到一个描述性的作用)
 * 系统底层启动mybatis框架会基于@Mapper注解的描述,创建其接口的实现类,并将其实现类对象交给spring管理
 */
@Mapper
public interface GoodsDao {
    /**
     * 基于id删除数据库中商品信息
     * @param id
     * @return
     */
    @Delete("delete from tb_goods where id=#{id}")
    int deleteById(Integer id);

    /**
     * 基于id进行批量删除操作
     * @param ids
     * @return
     */
    //int deleteObjects(@Param("ids")Integer...ids);早期版本需要基于@Param注解
    int deleteObjects(Integer...ids);//sql映射中可使用array,ids参数名来接收方法参数

    /**
     * 查找所有商品信息
     * @return
     */
    @Select("SELECT id,name,remark,createdTime FROM tb_goods")
    List<Goods> findObjects();

    @Insert("insert into tb_goods (name,remark,createdTime) values(#{name},#{remark},now())")
    int insert(Goods entity);
}
