package com.cn.service.impl;

import com.cn.dao.IProductDao;
import com.cn.domain.product;
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
    public List<product> findAll() throws Exception {
        return iProductDao.findAll();
    }

    @Override
    public void save(product product) throws Exception {
        iProductDao.save(product);
    }

    @Override
    public product findById(Integer id) throws Exception {
        return iProductDao.findById(id);
    }

    @Override
    public void delete(Long id) throws Exception {
        iProductDao.delete(id);
    }

    @Override
    public void update(product product) throws Exception {
        System.out.println(product);
        iProductDao.update(product);
    }
}
