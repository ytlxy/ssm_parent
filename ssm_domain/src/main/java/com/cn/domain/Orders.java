package com.cn.domain;

import com.cn.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    private Long id; //主键 id
    private String orderNum; //订单编号 唯一
    private Date orderTime; //订单的时间
    private String orderTimeStr; //格式化的时间
    private Integer orderStatus; //订单状态 订单状态(0 未支付 1 已经支付)
    private String orderStatusStr; //格式化的订单状态
    private Integer peopleCount; //此订单多少人去
    private Product product; //商品
    private List<Traveller> travellers; //旅客们
    private Member member; //会员
    private Integer payType; //付款方式 支付方式(0 支付宝 1 微信 2 其他)
    private String payTypeStr; //格式化的付款方式
    private String orderDesc; //订单信息
    private Long productId; // 商品id
    private Long memberId;// 用户id

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", productId=" + productId +
                ", memberId=" + memberId +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.date2string(orderTime, "yyyy-MM-dd HH:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已经支付)
        if (orderStatus != null) {
            if (orderStatus != 1) {
                orderStatusStr = "未支付";
            }
            if (orderStatus == 1) {
                orderStatusStr = "已经支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式(-1 未支付 0 支付宝 1 微信 2 其他)
        if (payType != null) {
            if (payType == 0) {
                payTypeStr = "支付宝";
            }
            if (payType == 1) {
                payTypeStr = "微信";
            }
            if (payType == 2) {
                payTypeStr = "其他";
            }
            if (payType == -1) {
                payTypeStr = "未支付";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
