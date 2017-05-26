package com.dodonew.entityVo;

/**
 * Created by yukx on 17/4/22.
 */
public class DoPayVo {
    private String orderId;
    private String storeId;
    private String notify_url;
    private String payOpenId;
    private Integer amount;
    private String body;
    private String remark;
    private String payType;
    private String formId;
    private String requestIp = "127.0.0.1";
    private double payAmount;
    private double favMoney;
    private Integer memberId;
    private Integer rechargeid;

    @Override
    public String toString() {
        return "DoPayVo{" +
                "orderId='" + orderId + '\'' +
                ", payOpenId='" + payOpenId + '\'' +
                ", payAmount=" + payAmount +
                ", favMoney=" + favMoney +
                ", memberId=" + memberId +
                ", rechargeid=" + rechargeid +
                ", formId=" + formId +
                '}';
    }

    public double getFavMoney() {
        return favMoney;
    }

    public void setFavMoney(double favMoney) {
        this.favMoney = favMoney;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Integer getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(Integer rechargeid) {
        this.rechargeid = rechargeid;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getPayOpenId() {
        return payOpenId;
    }

    public void setPayOpenId(String payOpenId) {
        this.payOpenId = payOpenId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
