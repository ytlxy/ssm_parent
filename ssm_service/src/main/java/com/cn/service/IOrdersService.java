package com.cn.service;

import com.cn.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll()throws Exception;
//    public void findByadd(orders orders)throws Exception;
}
