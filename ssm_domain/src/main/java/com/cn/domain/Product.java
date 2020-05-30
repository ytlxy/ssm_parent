package com.cn.domain;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departrueTime;
    private String departrueTimeStr;
    private String productPrice;
    private Double productDesc;
    private Integer productStatus;
    private String productStatusStr;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departrueTime=" + departrueTime +
                ", departrueTimeStr='" + departrueTimeStr + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDesc=" + productDesc +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartrueTime() {
        return departrueTime;
    }

    public void setDepartrueTime(Date departrueTime) {
        this.departrueTime = departrueTime;
    }

    public String getDepartrueTimeStr() {
        return departrueTimeStr;
    }

    public void setDepartrueTimeStr(String departrueTimeStr) {
        this.departrueTimeStr = departrueTimeStr;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(Double productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
