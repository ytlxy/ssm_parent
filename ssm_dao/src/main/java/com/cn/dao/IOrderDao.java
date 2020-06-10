package com.cn.dao;

import com.cn.domain.Member;
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
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType =Product.class,one=@One(select = "com.cn.dao.IProductDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select ="com.cn.dao.ITravellerDao.findByOrdersId"))
    })
    public List<Orders> findAll() throws Exception;

    /**
     * 根据id 查询具体的 Orders 对象
     * @param id 需要查询的 id
     * @return 返回查询到的 id 对象
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "productId",column = "productId"),
            @Result(property = "memberId",column = "memberId"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.cn.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.cn.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.cn.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(Integer id);
}
