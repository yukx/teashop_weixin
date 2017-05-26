package com.dodonew.entityVo;

/**
 * Created by yukx on 17/4/22.
 */
public class DecodeVo {
    private String iv;
    private String encryptedData;
    private String session;
    private String orderId;
    private String session_key;
    private String openId;
    private String storeId;
    private String unionId;
    private int payAmount;

    @Override
    public String toString() {
        return "DecodeVo{" +
                "iv='" + iv + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", session='" + session + '\'' +
                ", orderId='" + orderId + '\'' +
                ", session_key='" + session_key + '\'' +
                ", openId='" + openId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", payAmount=" + payAmount +
                '}';
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
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

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
