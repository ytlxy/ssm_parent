package com.cn.service.impl;

import com.cn.dao.IOrderDao;
import com.cn.domain.Orders;
import com.cn.service.IOrdersService;
import com.github.pagehelper.PageHelper;
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
    public List<Orders> findAll(int page,int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return iOrderDao.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return iOrderDao.findById(id);
    }
}
