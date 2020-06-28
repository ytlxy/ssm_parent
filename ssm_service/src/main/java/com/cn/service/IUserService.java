package com.cn.service;

import com.cn.domain.Role;
import com.cn.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll(int page, int pageSize) throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public void update(UserInfo userInfo);

    public void delete(Integer id);

    public UserInfo findByUserId(String username) throws Exception;

    public UserInfo findById(Integer id) throws Exception;

    public List<Role> findOtherRoles(Integer id) throws Exception;

    public void addRoleToUser(Long userId,Long ... roleIds) throws Exception;
}
