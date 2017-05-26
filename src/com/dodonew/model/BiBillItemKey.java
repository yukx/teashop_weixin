package com.dodonew.model;

public class BiBillItemKey {

    /*public BiBillItemKey(int storeId, String billid, String billitemid){
        this.billid = billid;
        this.storeid = storeId;
        this.billitemid = billitemid;
    }*/

    private String storeid;

    private String billitemid;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    private String billid;

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getBillitemid() {
        return billitemid;
    }

    public void setBillitemid(String billitemid) {
        this.billitemid = billitemid == null ? null : billitemid.trim();
    }
}