package com.cn.dao;

import com.cn.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPermissionDao {
    @Select("select * from permission where id in(select permission from role_permission where roleId=#{id})")
    public List<Permission> findAllPermissionByRoleId(Integer id);
}
