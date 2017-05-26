package com.dodonew.entityVo;

/**
 * Created by yukx on 17/4/21.
 */
public class checkVo {
    private String token = "402881b150ef593b0150ef593b850000";
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    @Override
    public String toString() {
        return "checkVo{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", echostr='" + echostr + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
