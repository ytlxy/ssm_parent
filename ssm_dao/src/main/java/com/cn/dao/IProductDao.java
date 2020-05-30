package com.cn.dao;

import com.cn.domain.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findAll() throws Exception;
}
