package com.cn.dao;

import com.cn.domain.Permission;
import com.cn.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.cn.dao.IPermissionDao.findAllPermissionByRoleId"))
    })
    public List<Role> findAllRoleByUserId(Integer id);

    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from role where id=#{id}")
    public Role findById(Integer id) throws Exception;

    @Select("select *from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findPermission() throws Exception;

    @Insert("insert into role_permission (roleId,permissionId)values(#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId) throws Exception;

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.cn.dao.IPermissionDao.findAllPermissionByRoleId"))
    })
    public Role findById2(Integer id) throws Exception;

    @Delete("delete from role_permission where roleId=#{id}")
    public void deleteFormRole_permission(Integer id) throws Exception;

    @Delete("delete from permission where id=#{id}")
    public void deleteFromPermission(Integer id) throws Exception;

    @Delete("delete from role where id=#{id}")
    public void deleteRoleById(Integer id) throws Exception;
}
