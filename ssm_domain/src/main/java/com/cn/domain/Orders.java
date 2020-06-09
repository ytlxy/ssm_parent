package com.cn.domain;

import com.cn.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
    private Long id;
    private String orderNun;
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private String payTypeStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Product product;
    private List<Traveller> travellers;
    private Member member;

    @Override
    public String toString() {
        return "orders{" +
                "id=" + id +
                ", orderNun='" + orderNun + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNun() {
        return orderNun;
    }

    public void setOrderNun(String orderNun) {
        this.orderNun = orderNun;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null)
            setOrderTimeStr(DateUtils.date2string(orderTime,"yyyy-MM-dd HH:mm:ss"));
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType != null)
            if (payType == 0)
                setPayTypeStr("支付宝");
        if (payType == 1)
            payTypeStr="微信";
        if (payType == 2)
            payTypeStr="其他";
        if (payType == -1)
            payTypeStr="未支付";
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(orderStatus != null)
            if (orderStatus !=1)
                orderStatusStr="未支付";
        if (orderStatus == 1)
            orderStatusStr="已支付";
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        member = member;
    }
}
