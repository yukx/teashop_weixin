package com.dodonew.entityVo;

/**
 * Created by yukx on 17/5/3.
 */
public class CardPayVo {
    private String storeId;
    private Integer memberId;
    private String orderId;
    private String formId;
    private String storeName;
    private String openId;
    private double payAmount;
    private Integer realAmount; // 实际支付金额
    private Integer orderAmount;

    @Override
    public String toString() {
        return "CardPayVo{" +
                "storeId='" + storeId + '\'' +
                ", memberId=" + memberId +
                ", orderId='" + orderId + '\'' +
                ", formId='" + formId + '\'' +
                ", openId='" + openId + '\'' +
                ", payAmount=" + payAmount +
                ", realAmount=" + realAmount +
                '}';
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }
}
