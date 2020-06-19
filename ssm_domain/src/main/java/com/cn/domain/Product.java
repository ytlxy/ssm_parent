package com.cn.domain;

import com.cn.utils.DateUtils;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@ToString
public class Product implements Serializable {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departrueTime;
    private String departrueTimeStr;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

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

    public void setDepartrueTime(Date departrueTime) throws Exception {
        this.departrueTime = departrueTime;
    }

    public String getDepartrueTimeStr() {
        if (departrueTime != null) {
            setDepartrueTimeStr(DateUtils.date2string(departrueTime, "yyyy-MM-dd HH:mm:ss"));
        }
        return departrueTimeStr;
    }

    public void setDepartrueTimeStr(String departrueTimeStr) {
        this.departrueTimeStr = departrueTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (getProductStatus() != null) {
            if (getProductStatus() == 0) {
                productStatusStr = "关闭";
            }
            if (getProductStatus() == 1) {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
