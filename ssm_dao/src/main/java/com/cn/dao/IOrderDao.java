package com.cn.dao;

import com.cn.domain.Orders;
import org.apache.ibatis.annotations.*;
import com.cn.domain.Product;

import java.util.List;

public interface IOrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",javaType=Product.class,one=@One(select = "com.cn.dao.IProductDao.findById")),
            @Result(property = "travellers",column = "id",javaType=java.util.List.class,many=@Many(select = "com.cn.dao.ITravellerDao.findByOrdersId"))
    })
    public List<Orders> findAll() throws Exception;
//    @Insert("insert into orders(orderNun,orderTime,peopleCount,orderDesc,payType,orderStatus,productId,memberId)" +
//            "values(#{orderNun},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{productId},#{memberId})")
//    public void findByadd(Product product)throws Exception;
}
