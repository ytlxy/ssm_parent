package com.cn.dao;

import com.cn.domain.product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    public List<product> findAll() throws Exception;
    @Insert("insert into product(productNum,productName,cityName,departrueTime,productPrice,productDesc,productStatus)"
            +"values(#{productNum},#{productName},#{cityName},#{departrueTime},#{productPrice},#{productDesc},1)")
    public void save(product product) throws Exception;
}
