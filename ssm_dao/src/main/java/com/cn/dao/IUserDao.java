package com.cn.dao;

import com.cn.domain.Role;
import com.cn.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.cn.dao.IRoleDao.findAllRoleByUserId"))
    })
    public UserInfo findByUserId(String username) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.cn.dao.IRoleDao.findAllRoleByUserId"))
    })
    public UserInfo findById(Integer id) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    @Delete("delete from users where id=#{id}")
    public void delete(Integer id);

    @Update("update users set email=#{email},username=#{username},password=#{password},status=#{status} where id=#{id}")
    public void update(UserInfo userInfo);

    @Insert("insert into " +
            "users(id,email,username,password,phoneNum,status)"
            + " values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    public List<Role> findOtherRoles(Integer id) throws Exception;

    @Insert("insert into users_role (userId,roleId)values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") Long userId,@Param("roleId") Long roleId) throws Exception;
}
