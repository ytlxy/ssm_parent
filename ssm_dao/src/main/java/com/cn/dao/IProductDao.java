package com.cn.dao;

import com.cn.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductDao {
    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into " +
            "product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)"
            + " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},"
            + "#{productDesc},#{productStatus})")
    public void save(Product product) throws Exception;

    /**
     * 根据 id 查询一个产品
     * @param id 需要查询的 产品 id
     * @return 返回一个 Product 对象
     */
    @Select("select * from product where id=#{id}")
    public Product findById(Integer id) throws Exception;

    /**
     * 删除一个对象
     * @param id
     */
    @Delete("delete from product where id=#{id}")
    public void delete(Long id);

    /**
     * 更新信息
     * @param product 需要更新的对象
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTim e=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productSta tus=#{productStatus} where id=#{id}")
    public void update(Product product);
}
