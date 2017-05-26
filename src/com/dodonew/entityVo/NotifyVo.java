package com.dodonew.entityVo;

/**
 * Created by yukx on 17/5/8.
 */
public class NotifyVo {

    private String transationId;
    private String ddnorderId;
    private String partnerOrderId;
    private String time;
    private String sign;

    @Override
    public String toString() {
        return "NotifyVo{" +
                "transationId='" + transationId + '\'' +
                ", ddnorderId='" + ddnorderId + '\'' +
                ", partnerOrderId='" + partnerOrderId + '\'' +
                ", time='" + time + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public String getTransationId() {
        return transationId;
    }

    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }

    public String getDdnorderId() {
        return ddnorderId;
    }

    public void setDdnorderId(String ddnorderId) {
        this.ddnorderId = ddnorderId;
    }

    public String getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(String partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
