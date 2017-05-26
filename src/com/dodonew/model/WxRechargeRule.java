package com.dodonew.model;

public class WxRechargeRule {
    private Integer rechargeid;

    private Integer rechargenum;

    private Double givenumber;

    private String remark;

    private String storeid;

    private Integer discountshowprice;

    private int balance;

    private int payAmount;

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(Integer rechargeid) {
        this.rechargeid = rechargeid;
    }

    public Integer getRechargenum() {
        return rechargenum;
    }

    public void setRechargenum(Integer rechargenum) {
        this.rechargenum = rechargenum;
    }

    public Double getGivenumber() {
        return givenumber;
    }

    public void setGivenumber(Double givenumber) {
        this.givenumber = givenumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public Integer getDiscountshowprice() {
        return discountshowprice;
    }

    public void setDiscountshowprice(Integer discountshowprice) {
        this.discountshowprice = discountshowprice;
    }
}