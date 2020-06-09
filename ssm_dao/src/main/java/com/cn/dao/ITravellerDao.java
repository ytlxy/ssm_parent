package com.cn.dao;

import com.cn.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellerDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrdersId(Integer orderid)throws Exception;
}
