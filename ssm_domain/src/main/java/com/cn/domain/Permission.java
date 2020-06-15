package com.cn.domain;

import lombok.Data;

import java.util.List;
@Data
public class Permission {
    private Long id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
