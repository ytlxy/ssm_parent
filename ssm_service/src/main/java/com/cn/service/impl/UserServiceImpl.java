package com.cn.service.impl;

import com.cn.dao.IUserDao;
import com.cn.domain.Role;
import com.cn.domain.UserInfo;
import com.cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
        userInfo=userDao.findByUserId(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user1=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==1 ? true : false,true,true,true,getAuthority(userInfo.getRoles()));
        return user1;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        for (Role role:roles){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }
}
