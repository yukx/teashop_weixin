package com.dodonew.model;

public class Wx_MemberCardKey {
    private Integer storeId;

    private String cardNO;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getCardNO() {
        return cardNO;
    }

    public void setCardNO(String cardNO) {
        this.cardNO = cardNO == null ? null : cardNO.trim();
    }
}