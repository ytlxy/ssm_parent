package com.cn.controller;

import com.cn.domain.Orders;
import com.cn.domain.Product;
import com.cn.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv=new ModelAndView();
//        List<Orders> li=ordersService.findAll();
//        System.out.println(li);
//        mv.addObject("orderList",li);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam
            (name = "pageSize",required = true,defaultValue = "5") Integer pageSize) throws Exception{
    ModelAndView mv=new ModelAndView();
    List<Orders> li=ordersService.findAll(page,pageSize);
    PageInfo pageInfo=new PageInfo(li);
        System.out.println(li);
    mv.addObject("pageInfo",pageInfo);
    mv.setViewName("orders-page-list");
    return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Orders li=ordersService.findById(id);
        mv.addObject("orders",li);
        mv.setViewName("orders-show");
        return mv;
    }
}
