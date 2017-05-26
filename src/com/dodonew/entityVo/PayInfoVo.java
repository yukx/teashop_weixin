package com.dodonew.entityVo;

import com.dodonew.model.WxRechargeRule;

import java.util.List;

/**
 * Created by yukx on 17/5/2.
 */
public class PayInfoVo {
    private String storeId;
    private String storeName;
    private String openId;
    private String unionId;
    private String orderId;
    private Integer memberId;
    private double payAmount;
    private boolean isMember;
    private boolean isPayAll;
    private double balance;

    private List<WxRechargeRule> ruleList;

    @Override
    public String toString() {
        return "PayInfoVo{" +
                "storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", memberId=" + memberId +
                ", payAmount=" + payAmount +
                ", isMember=" + isMember +
                ", isPayAll=" + isPayAll +
                ", balance=" + balance +
                ", ruleList=" + ruleList +
                '}';
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isPayAll() {
        return isPayAll;
    }

    public void setPayAll(boolean payAll) {
        isPayAll = payAll;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public List<WxRechargeRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<WxRechargeRule> ruleList) {
        this.ruleList = ruleList;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
