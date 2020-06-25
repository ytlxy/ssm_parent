package com.cn.service.impl;

import com.cn.dao.IRoleDao;
import com.cn.domain.Permission;
import com.cn.domain.Role;
import com.cn.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(Integer id) throws Exception {
        return iRoleDao.findById(id);
    }

    @Override
    public List<Permission> findPermission(Integer roleId) throws Exception {
        return iRoleDao.findPermission();
    }

    @Override
    public void addPermissionToRole(Long roleId, Long... permId) throws Exception {
        for (Long pid : permId) {
            iRoleDao.addPermissionToRole(roleId, pid);
        }
    }

    @Override
    public Role findById2(Integer id) throws Exception {
        return iRoleDao.findById2(id);
    }

    @Override
    public void deleteRoleById(Integer id) throws Exception {
        iRoleDao.deleteFormRole_permission(id);
        iRoleDao.deleteFromPermission(id);
        iRoleDao.deleteRoleById(id);
    }

}
