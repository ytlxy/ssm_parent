package com.cn.dao;

import com.cn.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermission {
    @Select("select * from permission where id in(select permission from role_permission where roleId=#{id})")
    public List<Permission> findAllPermissionByRoleId(Integer id);
}
