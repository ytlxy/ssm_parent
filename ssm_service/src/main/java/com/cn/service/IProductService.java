package com.cn.service;

import com.cn.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;

    public void save(Product product) throws Exception;

    public Product findById(Integer id) throws Exception;

    public void delete(Long id) throws Exception;

    public void update(Product product) throws Exception;
}
