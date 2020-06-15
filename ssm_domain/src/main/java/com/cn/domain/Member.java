package com.cn.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Member implements Serializable {
    private Long id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;

}
