package com.dodonew.entityVo;

import com.dodonew.model.EZ_GoodsSpecCustomer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by maxiao on 2017/5/5.
 */
public class BiBillVo {

    private String storeId;
    private String billId;
    private double sumForDiscount;
    private double sumOfConsume ;
    private double sumToPay ;
    private double sumPaid ;
    private double reduceMantissa;
    private String memberId ;
    private String chargePersonId ;
    private String checkOutPersonId ;
    private List<Map<String,String>> goods;
    private double retailPrice;
    private  String subjectID;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "BiBillVo{" +
                "storeId='" + storeId + '\'' +
                ", sumForDiscount=" + sumForDiscount +
                ", sumOfConsume=" + sumOfConsume +
                ", sumToPay=" + sumToPay +
                ", sumPaid=" + sumPaid +
                ", reduceMantissa=" + reduceMantissa +
                ", memberId='" + memberId + '\'' +
                ", chargePersonId='" + chargePersonId + '\'' +
                ", checkOutPersonId='" + checkOutPersonId + '\'' +
                ", goods=" + goods +
                ", retailPrice=" + retailPrice +
                '}';
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public double getSumForDiscount() {
        return sumForDiscount;
    }

    public void setSumForDiscount(double sumForDiscount) {
        this.sumForDiscount = sumForDiscount;
    }

    public double getSumOfConsume() {
        return sumOfConsume;
    }

    public void setSumOfConsume(double sumOfConsume) {
        this.sumOfConsume = sumOfConsume;
    }

    public double getSumToPay() {
        return sumToPay;
    }

    public void setSumToPay(double sumToPay) {
        this.sumToPay = sumToPay;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public double getReduceMantissa() {
        return reduceMantissa;
    }

    public void setReduceMantissa(double reduceMantissa) {
        this.reduceMantissa = reduceMantissa;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getChargePersonId() {
        return chargePersonId;
    }

    public void setChargePersonId(String chargePersonId) {
        this.chargePersonId = chargePersonId;
    }

    public String getCheckOutPersonId() {
        return checkOutPersonId;
    }

    public void setCheckOutPersonId(String checkOutPersonId) {
        this.checkOutPersonId = checkOutPersonId;
    }

    public List<Map<String, String>> getGoods() {
        return goods;
    }

    public void setGoods(List<Map<String, String>> goods) {
        this.goods = goods;
    }

    public static void main(String[] args) {

        System.out.println(

        new GsonBuilder().serializeNulls().create().toJson(new BiBillVo())
        );
    }
}
