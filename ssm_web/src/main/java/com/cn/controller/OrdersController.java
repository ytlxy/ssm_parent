package com.cn.controller;

import com.cn.domain.Orders;
import com.cn.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> li=ordersService.findAll();
        System.out.println(li);
        mv.addObject("orderslist",li);
        mv.setViewName("orders-list");
        return mv;
    }
//    public String findbyadd(orders orders) throws Exception {
//        ordersService.findByadd(orders);
//        return "redirect:findAll.do";
//    }
}
