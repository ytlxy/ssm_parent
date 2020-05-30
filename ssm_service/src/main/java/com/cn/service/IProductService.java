package com.cn.service;

import com.cn.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;
}
