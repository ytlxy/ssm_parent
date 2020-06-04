package com.cn.dao;

import com.cn.domain.product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    public List<product> findAll() throws Exception;
    @Insert("insert into product(productNum,productName,cityName,departrueTime,productPrice,productDesc,productStatus)"
            +"values(#{productNum},#{productName},#{cityName},#{departrueTime},#{productPrice},#{productDesc},1)")
    public void save(product product) throws Exception;
    @Select("select * from product where id=#{id}")
    public product findById(Integer id) throws Exception;
    @Delete("delete from product where id=#{id}")
    public void delete(Long id) throws Exception;
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departrueTime=#{departrueTime}," +
            "productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    public void update(product product) throws Exception;
}
