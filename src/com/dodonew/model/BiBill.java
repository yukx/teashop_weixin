package com.dodonew.model;

import java.util.Date;

public class BiBill extends BiBillKey {
    private String tableid;

    private Integer subtableid;

    private String tablename;

    private String tablefullname;

    private String tableareaid;

    private String tableareaname;

    private String tabletypeid;

    private String tabletypename;

    private String memberid;

    private String membercardid;

    private String membername;

    private Integer peoplecount;

    private String chargepersonid;

    private String chargeperson;

    private Date createtime;

    private String createpersonid;

    private String createperson;

    private int ischeckouting;

    private Date checkouttime;

    private String checkoutpersonid;

    private String checkoutperson;

    private Boolean checkoutnull;

    private String deletetime;

    private String deletepersonid;

    private String deleteperson;

    private String discountid;

    private String discountname;

    private Float discountrate;

    private String discountpersonid;

    private String discountperson;

    private Double sumofconsume;

    private Float servicerate;

    private Double sumofservice;

    private Double sumfordiscount;

    private Float sumofcarry;

    private Double sumtopay;

    private Double sumpaid;

    private Float sumincash;

    private Float sumofinvoice;

    private Float sumofcashpaid;

    private Float sumofcashback;

    private Date billdate;

    private String billperiod;

    private Integer billyear;

    private Integer billmonth;

    private Integer billday;

    private Boolean isarchived;

    private Boolean isuploaded;

    private Boolean isdeleted;

    private Integer printcount;

    private Float reducemantissa;

    private String branchid;

    private String branchname;

    private String workstationid;

    private String workstationname;

    private String remark;

    private String originalid;

    private String shiftid;

    private Date inserttime;

    private String subjectid;

    private String subjectname;

    private Float atleasecost;

    private String devid;

    private Integer billfrom;

    private String ddnbillid;

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    public Integer getSubtableid() {
        return subtableid;
    }

    public void setSubtableid(Integer subtableid) {
        this.subtableid = subtableid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getTablefullname() {
        return tablefullname;
    }

    public void setTablefullname(String tablefullname) {
        this.tablefullname = tablefullname == null ? null : tablefullname.trim();
    }

    public String getTableareaid() {
        return tableareaid;
    }

    public void setTableareaid(String tableareaid) {
        this.tableareaid = tableareaid == null ? null : tableareaid.trim();
    }

    public String getTableareaname() {
        return tableareaname;
    }

    public void setTableareaname(String tableareaname) {
        this.tableareaname = tableareaname == null ? null : tableareaname.trim();
    }

    public String getTabletypeid() {
        return tabletypeid;
    }

    public void setTabletypeid(String tabletypeid) {
        this.tabletypeid = tabletypeid == null ? null : tabletypeid.trim();
    }

    public String getTabletypename() {
        return tabletypename;
    }

    public void setTabletypename(String tabletypename) {
        this.tabletypename = tabletypename == null ? null : tabletypename.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getMembercardid() {
        return membercardid;
    }

    public void setMembercardid(String membercardid) {
        this.membercardid = membercardid == null ? null : membercardid.trim();
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getChargepersonid() {
        return chargepersonid;
    }

    public void setChargepersonid(String chargepersonid) {
        this.chargepersonid = chargepersonid == null ? null : chargepersonid.trim();
    }

    public String getChargeperson() {
        return chargeperson;
    }

    public void setChargeperson(String chargeperson) {
        this.chargeperson = chargeperson == null ? null : chargeperson.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(String createpersonid) {
        this.createpersonid = createpersonid == null ? null : createpersonid.trim();
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson == null ? null : createperson.trim();
    }

    public int getIscheckouting() {
        return ischeckouting;
    }

    public void setIscheckouting(int ischeckouting) {
        this.ischeckouting = ischeckouting;
    }

    public Date getCheckouttime() {
        return checkouttime;
    }

    public void setCheckouttime(Date checkouttime) {
        this.checkouttime = checkouttime;
    }

    public String getCheckoutpersonid() {
        return checkoutpersonid;
    }

    public void setCheckoutpersonid(String checkoutpersonid) {
        this.checkoutpersonid = checkoutpersonid == null ? null : checkoutpersonid.trim();
    }

    public String getCheckoutperson() {
        return checkoutperson;
    }

    public void setCheckoutperson(String checkoutperson) {
        this.checkoutperson = checkoutperson == null ? null : checkoutperson.trim();
    }

    public Boolean getCheckoutnull() {
        return checkoutnull;
    }

    public void setCheckoutnull(Boolean checkoutnull) {
        this.checkoutnull = checkoutnull;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime == null ? null : deletetime.trim();
    }

    public String getDeletepersonid() {
        return deletepersonid;
    }

    public void setDeletepersonid(String deletepersonid) {
        this.deletepersonid = deletepersonid == null ? null : deletepersonid.trim();
    }

    public String getDeleteperson() {
        return deleteperson;
    }

    public void setDeleteperson(String deleteperson) {
        this.deleteperson = deleteperson == null ? null : deleteperson.trim();
    }

    public String getDiscountid() {
        return discountid;
    }

    public void setDiscountid(String discountid) {
        this.discountid = discountid == null ? null : discountid.trim();
    }

    public String getDiscountname() {
        return discountname;
    }

    public void setDiscountname(String discountname) {
        this.discountname = discountname == null ? null : discountname.trim();
    }

    public Float getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(Float discountrate) {
        this.discountrate = discountrate;
    }

    public String getDiscountpersonid() {
        return discountpersonid;
    }

    public void setDiscountpersonid(String discountpersonid) {
        this.discountpersonid = discountpersonid == null ? null : discountpersonid.trim();
    }

    public String getDiscountperson() {
        return discountperson;
    }

    public void setDiscountperson(String discountperson) {
        this.discountperson = discountperson == null ? null : discountperson.trim();
    }

    public Double getSumofconsume() {
        return sumofconsume;
    }

    public void setSumofconsume(Double sumofconsume) {
        this.sumofconsume = sumofconsume;
    }

    public Float getServicerate() {
        return servicerate;
    }

    public void setServicerate(Float servicerate) {
        this.servicerate = servicerate;
    }

    public Double getSumofservice() {
        return sumofservice;
    }

    public void setSumofservice(Double sumofservice) {
        this.sumofservice = sumofservice;
    }

    public Double getSumfordiscount() {
        return sumfordiscount;
    }

    public void setSumfordiscount(Double sumfordiscount) {
        this.sumfordiscount = sumfordiscount;
    }

    public Float getSumofcarry() {
        return sumofcarry;
    }

    public void setSumofcarry(Float sumofcarry) {
        this.sumofcarry = sumofcarry;
    }

    public Double getSumtopay() {
        return sumtopay;
    }

    public void setSumtopay(Double sumtopay) {
        this.sumtopay = sumtopay;
    }

    public Double getSumpaid() {
        return sumpaid;
    }

    public void setSumpaid(Double sumpaid) {
        this.sumpaid = sumpaid;
    }

    public Float getSumincash() {
        return sumincash;
    }

    public void setSumincash(Float sumincash) {
        this.sumincash = sumincash;
    }

    public Float getSumofinvoice() {
        return sumofinvoice;
    }

    public void setSumofinvoice(Float sumofinvoice) {
        this.sumofinvoice = sumofinvoice;
    }

    public Float getSumofcashpaid() {
        return sumofcashpaid;
    }

    public void setSumofcashpaid(Float sumofcashpaid) {
        this.sumofcashpaid = sumofcashpaid;
    }

    public Float getSumofcashback() {
        return sumofcashback;
    }

    public void setSumofcashback(Float sumofcashback) {
        this.sumofcashback = sumofcashback;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public String getBillperiod() {
        return billperiod;
    }

    public void setBillperiod(String billperiod) {
        this.billperiod = billperiod == null ? null : billperiod.trim();
    }

    public Integer getBillyear() {
        return billyear;
    }

    public void setBillyear(Integer billyear) {
        this.billyear = billyear;
    }

    public Integer getBillmonth() {
        return billmonth;
    }

    public void setBillmonth(Integer billmonth) {
        this.billmonth = billmonth;
    }

    public Integer getBillday() {
        return billday;
    }

    public void setBillday(Integer billday) {
        this.billday = billday;
    }

    public Boolean getIsarchived() {
        return isarchived;
    }

    public void setIsarchived(Boolean isarchived) {
        this.isarchived = isarchived;
    }

    public Boolean getIsuploaded() {
        return isuploaded;
    }

    public void setIsuploaded(Boolean isuploaded) {
        this.isuploaded = isuploaded;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getPrintcount() {
        return printcount;
    }

    public void setPrintcount(Integer printcount) {
        this.printcount = printcount;
    }

    public Float getReducemantissa() {
        return reducemantissa;
    }

    public void setReducemantissa(Float reducemantissa) {
        this.reducemantissa = reducemantissa;
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid == null ? null : branchid.trim();
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname == null ? null : branchname.trim();
    }

    public String getWorkstationid() {
        return workstationid;
    }

    public void setWorkstationid(String workstationid) {
        this.workstationid = workstationid == null ? null : workstationid.trim();
    }

    public String getWorkstationname() {
        return workstationname;
    }

    public void setWorkstationname(String workstationname) {
        this.workstationname = workstationname == null ? null : workstationname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOriginalid() {
        return originalid;
    }

    public void setOriginalid(String originalid) {
        this.originalid = originalid == null ? null : originalid.trim();
    }

    public String getShiftid() {
        return shiftid;
    }

    public void setShiftid(String shiftid) {
        this.shiftid = shiftid == null ? null : shiftid.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid == null ? null : subjectid.trim();
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname == null ? null : subjectname.trim();
    }

    public Float getAtleasecost() {
        return atleasecost;
    }

    public void setAtleasecost(Float atleasecost) {
        this.atleasecost = atleasecost;
    }

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid == null ? null : devid.trim();
    }

    public Integer getBillfrom() {
        return billfrom;
    }

    public void setBillfrom(Integer billfrom) {
        this.billfrom = billfrom;
    }

    public String getDdnbillid() {
        return ddnbillid;
    }

    public void setDdnbillid(String ddnbillid) {
        this.ddnbillid = ddnbillid == null ? null : ddnbillid.trim();
    }
}