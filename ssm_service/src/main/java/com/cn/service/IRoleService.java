package com.cn.service;

import com.cn.domain.Permission;
import com.cn.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    public void save(Role role) throws Exception;

    public Role findById(Integer id) throws Exception;

    public List<Permission> findPermission(Integer roleId) throws Exception;

    public void addPermissionToRole(Long roleId, Long... permId) throws Exception;

    public Role findById2(Integer id) throws Exception;

    public void deleteRoleById(Integer id)throws Exception;
}
