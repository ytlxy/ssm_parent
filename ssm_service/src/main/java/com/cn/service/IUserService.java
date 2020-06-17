package com.cn.service;

import com.cn.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll(int page,int pageSize)throws Exception;
}
