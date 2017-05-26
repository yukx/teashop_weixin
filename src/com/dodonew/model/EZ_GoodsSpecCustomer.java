package com.dodonew.model;

import java.util.Date;

public class EZ_GoodsSpecCustomer {
    private Long specCustomerId;

    private String storeId;

    private String goodsCode;

    private String goodsName;

    private String goodsSpec;

    private Long goodsCustomerId;

    private Double price;

    private Date crateTime;

    private Date updateTime;

    private Integer status;

    public Long getSpecCustomerId() {
        return specCustomerId;
    }

    public void setSpecCustomerId(Long specCustomerId) {
        this.specCustomerId = specCustomerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public Long getGoodsCustomerId() {
        return goodsCustomerId;
    }

    public void setGoodsCustomerId(Long goodsCustomerId) {
        this.goodsCustomerId = goodsCustomerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
}