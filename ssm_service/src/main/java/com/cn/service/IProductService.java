package com.cn.service;

import com.cn.domain.product;

import java.util.List;

public interface IProductService {
    public List<product> findAll() throws Exception;
    public void save(product product) throws Exception;
}
