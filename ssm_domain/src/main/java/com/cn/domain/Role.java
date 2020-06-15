package com.cn.domain;

import lombok.Data;

import java.util.List;
@Data
public class Role {
    private Long id;
    private String roleName;
    private String roleDesc;
    private List<UserInfo> users;
    private List<Permission> permissions;
}
