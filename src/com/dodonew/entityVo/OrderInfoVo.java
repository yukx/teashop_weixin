package com.dodonew.entityVo;

import com.dodonew.model.BiBillItem;
import com.dodonew.model.Bi_EzItem;

import java.util.List;

/**
 * Created by yukx on 17/4/24.
 */
public class OrderInfoVo {

    private String orderId;
    private String storeId;
    private String storeName;
    private boolean isHWMember;
    private double hwDiscount;
    private boolean isSJMember;
    private double jsDiscount;
    private double payAmount;
    private double finalPayAmount;          // 最终支付金额
    private double sjDisAmount=0;         // 商家会员折扣金额
    private double hwDisAmount=0;
    //private List<BiBillItem> billItemList;
    private List<Bi_EzItem> ezItemList;

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "orderId='" + orderId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", isHWMember=" + isHWMember +
                ", hwDiscount=" + hwDiscount +
                ", isSJMember=" + isSJMember +
                ", jsDiscount=" + jsDiscount +
                ", payAmount=" + payAmount +
                ", finalPayAmount=" + finalPayAmount +
                ", sjDisAmount=" + sjDisAmount +
                ", hwDisAmount=" + hwDisAmount +
                ", ezItemList=" + ezItemList +
                '}';
    }

    public double getFinalPayAmount() {
        return finalPayAmount;
    }

    public void setFinalPayAmount(double finalPayAmount) {
        this.finalPayAmount = finalPayAmount;
    }

    public double getSjDisAmount() {
        return sjDisAmount;
    }

    public void setSjDisAmount(double sjDisAmount) {
        this.sjDisAmount = sjDisAmount;
    }

    public double getHwDisAmount() {
        return hwDisAmount;
    }

    public void setHwDisAmount(double hwDisAmount) {
        this.hwDisAmount = hwDisAmount;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isHWMember() {
        return isHWMember;
    }

    public void setHWMember(boolean HWMember) {
        isHWMember = HWMember;
    }

    public double getHwDiscount() {
        return hwDiscount;
    }

    public void setHwDiscount(double hwDiscount) {
        this.hwDiscount = hwDiscount;
    }

    public boolean isSJMember() {
        return isSJMember;
    }

    public void setSJMember(boolean SJMember) {
        isSJMember = SJMember;
    }

    public double getJsDiscount() {
        return jsDiscount;
    }

    public void setJsDiscount(double jsDiscount) {
        this.jsDiscount = jsDiscount;
    }

    public List<Bi_EzItem> getEzItemList() {
        return ezItemList;
    }

    public void setEzItemList(List<Bi_EzItem> ezItemList) {
        this.ezItemList = ezItemList;
    }
}
