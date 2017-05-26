package com.dodonew.model;

import java.util.Date;

public class WxPayOrderInfo {
    private String orderid;

    private String billid;

    private String storeid;

    private String storename;

    private Integer payamount;

    private Date createtime;

    private Byte checkoutstatus;

    private String openid;

    private String prepayid;

    private Integer payway;

    private Integer status;

    private String createpeople;

    private String rechargeid;

    private String memberid;

    private String paywayid;

    private String appid;

    private String paysign;

    private String carappid;

    private String noncestr;

    private String timestr;

    private String yueshorderid;

    private Integer weixinpaytype;

    private String remark;

    private Integer invoice;

    private String tableid;

    private String transactionId;

    private Byte isUsecoupon;

    private Integer discount;

    private String couponId;

    private Integer ordertype;

    private String ddnopenid;

    private Integer checknum;

    private Integer unpayamount;

    private Integer unusegiveamount;

    private Integer unuseblock;

    private Double carddiscount;

    private Integer realpayamount;

    private Integer favAmount;

    private String formId;

    public String getFormId() {
        return formId;
    }

    public Integer getFavAmount() {
        return favAmount;
    }

    public void setFavAmount(Integer favAmount) {
        this.favAmount = favAmount;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public Integer getPayamount() {
        return payamount;
    }

    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getCheckoutstatus() {
        return checkoutstatus;
    }

    public void setCheckoutstatus(Byte checkoutstatus) {
        this.checkoutstatus = checkoutstatus;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid == null ? null : prepayid.trim();
    }

    public Integer getPayway() {
        return payway;
    }

    public void setPayway(Integer payway) {
        this.payway = payway;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatepeople() {
        return createpeople;
    }

    public void setCreatepeople(String createpeople) {
        this.createpeople = createpeople == null ? null : createpeople.trim();
    }

    public String getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(String rechargeid) {
        this.rechargeid = rechargeid == null ? null : rechargeid.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getPaywayid() {
        return paywayid;
    }

    public void setPaywayid(String paywayid) {
        this.paywayid = paywayid == null ? null : paywayid.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPaysign() {
        return paysign;
    }

    public void setPaysign(String paysign) {
        this.paysign = paysign == null ? null : paysign.trim();
    }

    public String getCarappid() {
        return carappid;
    }

    public void setCarappid(String carappid) {
        this.carappid = carappid == null ? null : carappid.trim();
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr == null ? null : noncestr.trim();
    }

    public String getTimestr() {
        return timestr;
    }

    public void setTimestr(String timestr) {
        this.timestr = timestr == null ? null : timestr.trim();
    }

    public String getYueshorderid() {
        return yueshorderid;
    }

    public void setYueshorderid(String yueshorderid) {
        this.yueshorderid = yueshorderid == null ? null : yueshorderid.trim();
    }

    public Integer getWeixinpaytype() {
        return weixinpaytype;
    }

    public void setWeixinpaytype(Integer weixinpaytype) {
        this.weixinpaytype = weixinpaytype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public Byte getIsUsecoupon() {
        return isUsecoupon;
    }

    public void setIsUsecoupon(Byte isUsecoupon) {
        this.isUsecoupon = isUsecoupon;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public String getDdnopenid() {
        return ddnopenid;
    }

    public void setDdnopenid(String ddnopenid) {
        this.ddnopenid = ddnopenid == null ? null : ddnopenid.trim();
    }

    public Integer getChecknum() {
        return checknum;
    }

    public void setChecknum(Integer checknum) {
        this.checknum = checknum;
    }

    public Integer getUnpayamount() {
        return unpayamount;
    }

    public void setUnpayamount(Integer unpayamount) {
        this.unpayamount = unpayamount;
    }

    public Integer getUnusegiveamount() {
        return unusegiveamount;
    }

    public void setUnusegiveamount(Integer unusegiveamount) {
        this.unusegiveamount = unusegiveamount;
    }

    public Integer getUnuseblock() {
        return unuseblock;
    }

    public void setUnuseblock(Integer unuseblock) {
        this.unuseblock = unuseblock;
    }

    public Double getCarddiscount() {
        return carddiscount;
    }

    public void setCarddiscount(Double carddiscount) {
        this.carddiscount = carddiscount;
    }

    public Integer getRealpayamount() {
        return realpayamount;
    }

    public void setRealpayamount(Integer realpayamount) {
        this.realpayamount = realpayamount;
    }
}