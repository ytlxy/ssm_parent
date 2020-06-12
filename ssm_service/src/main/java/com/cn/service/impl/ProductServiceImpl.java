package com.cn.service.impl;

import com.cn.dao.IProductDao;
import com.cn.domain.Product;
import com.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//业务层子类必须要有Transactional
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }

    @Override
    public Product findById(Integer id) throws Exception {
        return iProductDao.findById(id);
    }

    @Override
    public void delete(Long id) throws Exception {
        iProductDao.delete(id);
    }

    @Override
    public void update(Product product) throws Exception {
        System.out.println(product);
        iProductDao.update(product);
    }
}
