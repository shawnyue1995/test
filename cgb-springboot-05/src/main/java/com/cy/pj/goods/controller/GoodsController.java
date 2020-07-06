package com.cy.pj.goods.controller;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    //http://localhost:8080/goods/doDeleteById
    @RequestMapping("doDeleteById")
    public String doDeleteById(Integer id){
        //调用业务层对象执行删除操作
        goodsService.deleteById(id);
        //思考:删除以后要做什么?
        //在当前业务中我们可以重定向到查询页面
        return "redirect:doGoodsUI";
    }

    @RequestMapping("doSaveGoods")
    public String doSaveGoods(Goods entity){
        goodsService.insert(entity);
        return "redirect:doGoodsUI";
    }

    //http:localhost:8080/goods/doGoodsUI
    //此访问路径会传递到DispatcherServlet对象
    //DispatcherServlet对象会基于用户输入的url找到对应的controller及方法
    //DispatcherServlet底层会根据反射技术调用对应的控制层方法
    @RequestMapping("doGoodsUI")
    public String doGoodsUI(Model model) {
        //获取业务数据
        List<Goods> list = goodsService.findGoods();
        //将数据存储到作用域对象
        model.addAttribute("list", list);
        //将页面响应到客户端
        return "goods";//view name
        //将此view返回给前端控制器DispatcherServlet
        //前端控制器会调用视图解析器对view进行解析,添加前缀和后缀
        //templates/pages/goods.html
        //最后由DispatcherServlet将页面响应给客户端
    }
}
