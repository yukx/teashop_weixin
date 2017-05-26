package com.dodonew.model;

import java.util.Date;

public class WxMemberConsume {
    private Integer serialno;

    private Integer memberid;

    private double consumemoney;

    private int consumetype;

    private String createtime;

    private String remark;

    private String storeid;

    private double lastbalance;

    private String billid;

    private String operator;

    private Integer isroam;

    private Integer roamstoreid;

    private String roamstorename;

    private Double givemoney;

    private Double discount;

    private Double orgmoney;

    private Double favmoney;

    private String orderid;

    public Integer getSerialno() {
        return serialno;
    }

    public void setSerialno(Integer serialno) {
        this.serialno = serialno;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public double getConsumemoney() {
        return consumemoney;
    }

    public void setConsumemoney(double consumemoney) {
        this.consumemoney = consumemoney;
    }

    public int getConsumetype() {
        return consumetype;
    }

    public void setConsumetype(int consumetype) {
        this.consumetype = consumetype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
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
        this.storeid = storeid == null ? null : storeid.trim();
    }

    public double getLastbalance() {
        return lastbalance;
    }

    public void setLastbalance(double lastbalance) {
        this.lastbalance = lastbalance;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getIsroam() {
        return isroam;
    }

    public void setIsroam(Integer isroam) {
        this.isroam = isroam;
    }

    public Integer getRoamstoreid() {
        return roamstoreid;
    }

    public void setRoamstoreid(Integer roamstoreid) {
        this.roamstoreid = roamstoreid;
    }

    public String getRoamstorename() {
        return roamstorename;
    }

    public void setRoamstorename(String roamstorename) {
        this.roamstorename = roamstorename == null ? null : roamstorename.trim();
    }

    public Double getGivemoney() {
        return givemoney;
    }

    public void setGivemoney(Double givemoney) {
        this.givemoney = givemoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getOrgmoney() {
        return orgmoney;
    }

    public void setOrgmoney(Double orgmoney) {
        this.orgmoney = orgmoney;
    }

    public Double getFavmoney() {
        return favmoney;
    }

    public void setFavmoney(Double favmoney) {
        this.favmoney = favmoney;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }
}