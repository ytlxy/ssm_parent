package com.cn.controller;

import com.cn.domain.product;
import com.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
    ModelAndView mv=new ModelAndView();
    List<product> pr=productService.findAll();
        System.out.println(pr);
    mv.addObject("productList",pr);
    mv.setViewName("product_list");
    return mv;
    }
}
