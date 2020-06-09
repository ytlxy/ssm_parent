package com.cn.service.impl;

import com.cn.dao.IOrderDao;
import com.cn.domain.Orders;
import com.cn.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrderDao iOrderDao;
    @Override
    public List<Orders> findAll() throws Exception {
        return iOrderDao.findAll();
    }

//    @Override
//    public void findByadd(Product product) throws Exception {
//        iOrderDao.findByadd(product);
//    }
}
