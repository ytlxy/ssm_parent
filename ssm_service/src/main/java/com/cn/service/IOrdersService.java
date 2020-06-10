package com.cn.service;

import com.cn.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(int page,int pageSize) throws Exception;
    public Orders findById(Integer id);
}
