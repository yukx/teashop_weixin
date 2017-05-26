package com.dodonew.model;

import java.util.Date;

public class EZ_GoodsCustomer {
    private Long goodsCustomerId;

    private String manuName;

    private String tradeMark;

    private String img;

    private String sd;

    private String gd;

    private String kd;

    private String ycd;

    private String engName;

    private String note;

    private String storeId;

    private Long goodsId;

    private Date crateTime;

    private Date updateTime;

    private Integer status;

    private Long goodsTypeCustomerId;

    private String goodsName;

    private String firstWords;

    private Integer isDiscount;

    private Integer isCoupon;

    public Long getGoodsCustomerId() {
        return goodsCustomerId;
    }

    public void setGoodsCustomerId(Long goodsCustomerId) {
        this.goodsCustomerId = goodsCustomerId;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName == null ? null : manuName.trim();
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark == null ? null : tradeMark.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd == null ? null : sd.trim();
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd == null ? null : gd.trim();
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd == null ? null : kd.trim();
    }

    public String getYcd() {
        return ycd;
    }

    public void setYcd(String ycd) {
        this.ycd = ycd == null ? null : ycd.trim();
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName == null ? null : engName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGoodsTypeCustomerId() {
        return goodsTypeCustomerId;
    }

    public void setGoodsTypeCustomerId(Long goodsTypeCustomerId) {
        this.goodsTypeCustomerId = goodsTypeCustomerId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getFirstWords() {
        return firstWords;
    }

    public void setFirstWords(String firstWords) {
        this.firstWords = firstWords == null ? null : firstWords.trim();
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    public Integer getIsCoupon() {
        return isCoupon;
    }

    public void setIsCoupon(Integer isCoupon) {
        this.isCoupon = isCoupon;
    }
}