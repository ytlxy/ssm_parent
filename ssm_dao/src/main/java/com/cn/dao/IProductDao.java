package com.cn.dao;

import com.cn.domain.product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    public List<product> findAll() throws Exception;
}
