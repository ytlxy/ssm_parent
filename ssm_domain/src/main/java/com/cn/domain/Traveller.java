package com.cn.domain;

import java.io.Serializable;

public class Traveller implements Serializable {
    private Long id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String creaentialsNum;
    private Integer travlelerType;
    private String travlelerTypeStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", creaentialsNum='" + creaentialsNum + '\'' +
                ", travlelerType=" + travlelerType +
                ", travlelerTypeStr='" + travlelerTypeStr + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType != null)
            if (credentialsType == 0)
                credentialsTypeStr = "身份证";
        if (credentialsType == 1)
            credentialsTypeStr = "护照";
        if (credentialsType == 2)
            credentialsTypeStr = "军官证";
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCreaentialsNum() {
        return creaentialsNum;
    }

    public void setCreaentialsNum(String creaentialsNum) {
        this.creaentialsNum = creaentialsNum;
    }

    public Integer getTravlelerType() {
        return travlelerType;
    }

    public void setTravlelerType(Integer travlelerType) {
        this.travlelerType = travlelerType;
    }

    public String getTravlelerTypeStr() {
        if (travlelerType != null)
            if (travlelerType == 0)
                travlelerTypeStr = "成人";
        if (travlelerType == 1)
            travlelerTypeStr = "儿童";
        return travlelerTypeStr;
    }

    public void setTravlelerTypeStr(String travlelerTypeStr) {
        this.travlelerTypeStr = travlelerTypeStr;
    }
}
