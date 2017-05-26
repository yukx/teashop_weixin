package com.dodonew.model;

import java.util.Date;

public class Pv_User extends Pv_UserKey {
    private String userName;

    private String userGroupID;

    private String password;

    private Boolean stopFlag;

    private String remark;

    private Float limitDiscount;

    private Integer allowPresent;

    private Integer allowLock;

    private String userPhone;

    private String powerItem;

    private String storeUserId;

    private Byte isGive;

    private Double giveMoney;

    private String thankWrite;

    private String openId;

    private Date createTime;

    private String createPeople;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(String userGroupID) {
        this.userGroupID = userGroupID == null ? null : userGroupID.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(Boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Float getLimitDiscount() {
        return limitDiscount;
    }

    public void setLimitDiscount(Float limitDiscount) {
        this.limitDiscount = limitDiscount;
    }

    public Integer getAllowPresent() {
        return allowPresent;
    }

    public void setAllowPresent(Integer allowPresent) {
        this.allowPresent = allowPresent;
    }

    public Integer getAllowLock() {
        return allowLock;
    }

    public void setAllowLock(Integer allowLock) {
        this.allowLock = allowLock;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getPowerItem() {
        return powerItem;
    }

    public void setPowerItem(String powerItem) {
        this.powerItem = powerItem == null ? null : powerItem.trim();
    }

    public String getStoreUserId() {
        return storeUserId;
    }

    public void setStoreUserId(String storeUserId) {
        this.storeUserId = storeUserId == null ? null : storeUserId.trim();
    }

    public Byte getIsGive() {
        return isGive;
    }

    public void setIsGive(Byte isGive) {
        this.isGive = isGive;
    }

    public Double getGiveMoney() {
        return giveMoney;
    }

    public void setGiveMoney(Double giveMoney) {
        this.giveMoney = giveMoney;
    }

    public String getThankWrite() {
        return thankWrite;
    }

    public void setThankWrite(String thankWrite) {
        this.thankWrite = thankWrite == null ? null : thankWrite.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople == null ? null : createPeople.trim();
    }
}