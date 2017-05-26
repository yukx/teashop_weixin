package com.dodonew.model;

import java.util.Date;

public class BiBillItem extends BiBillItemKey {
    private String billid;

    private String menuid;

    private String menuname;

    private String menuunitid;

    private String menuunitname;

    private String menutypeid;

    private String menutypename;

    private String departid;

    private String departname;

    private String departtypeid;

    private String departtypename;

    private Float amountorder;

    private Float amountontable;

    private Float amountcancel;

    private Float menuprice;

    private Float menuprice2;

    private Float sumofconsume;

    private Float sumfordiscount;

    private Float sumofservice;

    private Float sumofcookway;

    private String cookwayid;

    private String cookway;

    private Float cookwayprice;

    private String menupart;

    private String request;

    private String tastetype;

    private String createpersonid;

    private String createperson;

    private Date createtime;

    private Integer servingstate;

    private Boolean issentmenu;

    private Boolean issent;

    private String remark;

    private Boolean isspecialprice;

    private Boolean isdiscount;

    private Float discountrate;

    private Boolean isprinted;

    private String printtime;

    private Boolean isontable;

    private String ontabletime;

    private String menusetid;

    private String menusetname;

    private String menusetprefix;

    private String menusetitemid;

    private Float costprice;

    private Float taxrate;

    private Float sumoftax;

    private Integer isservice;

    private Byte istimemenu;

    private Float measuremin;

    private Float startmin;

    private Integer hasprintedtotal;

    private Double menucost;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuunitid() {
        return menuunitid;
    }

    public void setMenuunitid(String menuunitid) {
        this.menuunitid = menuunitid == null ? null : menuunitid.trim();
    }

    public String getMenuunitname() {
        return menuunitname;
    }

    public void setMenuunitname(String menuunitname) {
        this.menuunitname = menuunitname == null ? null : menuunitname.trim();
    }

    public String getMenutypeid() {
        return menutypeid;
    }

    public void setMenutypeid(String menutypeid) {
        this.menutypeid = menutypeid == null ? null : menutypeid.trim();
    }

    public String getMenutypename() {
        return menutypename;
    }

    public void setMenutypename(String menutypename) {
        this.menutypename = menutypename == null ? null : menutypename.trim();
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid == null ? null : departid.trim();
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getDeparttypeid() {
        return departtypeid;
    }

    public void setDeparttypeid(String departtypeid) {
        this.departtypeid = departtypeid == null ? null : departtypeid.trim();
    }

    public String getDeparttypename() {
        return departtypename;
    }

    public void setDeparttypename(String departtypename) {
        this.departtypename = departtypename == null ? null : departtypename.trim();
    }

    public Float getAmountorder() {
        return amountorder;
    }

    public void setAmountorder(Float amountorder) {
        this.amountorder = amountorder;
    }

    public Float getAmountontable() {
        return amountontable;
    }

    public void setAmountontable(Float amountontable) {
        this.amountontable = amountontable;
    }

    public Float getAmountcancel() {
        return amountcancel;
    }

    public void setAmountcancel(Float amountcancel) {
        this.amountcancel = amountcancel;
    }

    public Float getMenuprice() {
        return menuprice;
    }

    public void setMenuprice(Float menuprice) {
        this.menuprice = menuprice;
    }

    public Float getMenuprice2() {
        return menuprice2;
    }

    public void setMenuprice2(Float menuprice2) {
        this.menuprice2 = menuprice2;
    }

    public Float getSumofconsume() {
        return sumofconsume;
    }

    public void setSumofconsume(Float sumofconsume) {
        this.sumofconsume = sumofconsume;
    }

    public Float getSumfordiscount() {
        return sumfordiscount;
    }

    public void setSumfordiscount(Float sumfordiscount) {
        this.sumfordiscount = sumfordiscount;
    }

    public Float getSumofservice() {
        return sumofservice;
    }

    public void setSumofservice(Float sumofservice) {
        this.sumofservice = sumofservice;
    }

    public Float getSumofcookway() {
        return sumofcookway;
    }

    public void setSumofcookway(Float sumofcookway) {
        this.sumofcookway = sumofcookway;
    }

    public String getCookwayid() {
        return cookwayid;
    }

    public void setCookwayid(String cookwayid) {
        this.cookwayid = cookwayid == null ? null : cookwayid.trim();
    }

    public String getCookway() {
        return cookway;
    }

    public void setCookway(String cookway) {
        this.cookway = cookway == null ? null : cookway.trim();
    }

    public Float getCookwayprice() {
        return cookwayprice;
    }

    public void setCookwayprice(Float cookwayprice) {
        this.cookwayprice = cookwayprice;
    }

    public String getMenupart() {
        return menupart;
    }

    public void setMenupart(String menupart) {
        this.menupart = menupart == null ? null : menupart.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getTastetype() {
        return tastetype;
    }

    public void setTastetype(String tastetype) {
        this.tastetype = tastetype == null ? null : tastetype.trim();
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getServingstate() {
        return servingstate;
    }

    public void setServingstate(Integer servingstate) {
        this.servingstate = servingstate;
    }

    public Boolean getIssentmenu() {
        return issentmenu;
    }

    public void setIssentmenu(Boolean issentmenu) {
        this.issentmenu = issentmenu;
    }

    public Boolean getIssent() {
        return issent;
    }

    public void setIssent(Boolean issent) {
        this.issent = issent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsspecialprice() {
        return isspecialprice;
    }

    public void setIsspecialprice(Boolean isspecialprice) {
        this.isspecialprice = isspecialprice;
    }

    public Boolean getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(Boolean isdiscount) {
        this.isdiscount = isdiscount;
    }

    public Float getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(Float discountrate) {
        this.discountrate = discountrate;
    }

    public Boolean getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Boolean isprinted) {
        this.isprinted = isprinted;
    }

    public String getPrinttime() {
        return printtime;
    }

    public void setPrinttime(String printtime) {
        this.printtime = printtime == null ? null : printtime.trim();
    }

    public Boolean getIsontable() {
        return isontable;
    }

    public void setIsontable(Boolean isontable) {
        this.isontable = isontable;
    }

    public String getOntabletime() {
        return ontabletime;
    }

    public void setOntabletime(String ontabletime) {
        this.ontabletime = ontabletime == null ? null : ontabletime.trim();
    }

    public String getMenusetid() {
        return menusetid;
    }

    public void setMenusetid(String menusetid) {
        this.menusetid = menusetid == null ? null : menusetid.trim();
    }

    public String getMenusetname() {
        return menusetname;
    }

    public void setMenusetname(String menusetname) {
        this.menusetname = menusetname == null ? null : menusetname.trim();
    }

    public String getMenusetprefix() {
        return menusetprefix;
    }

    public void setMenusetprefix(String menusetprefix) {
        this.menusetprefix = menusetprefix == null ? null : menusetprefix.trim();
    }

    public String getMenusetitemid() {
        return menusetitemid;
    }

    public void setMenusetitemid(String menusetitemid) {
        this.menusetitemid = menusetitemid == null ? null : menusetitemid.trim();
    }

    public Float getCostprice() {
        return costprice;
    }

    public void setCostprice(Float costprice) {
        this.costprice = costprice;
    }

    public Float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Float taxrate) {
        this.taxrate = taxrate;
    }

    public Float getSumoftax() {
        return sumoftax;
    }

    public void setSumoftax(Float sumoftax) {
        this.sumoftax = sumoftax;
    }

    public Integer getIsservice() {
        return isservice;
    }

    public void setIsservice(Integer isservice) {
        this.isservice = isservice;
    }

    public Byte getIstimemenu() {
        return istimemenu;
    }

    public void setIstimemenu(Byte istimemenu) {
        this.istimemenu = istimemenu;
    }

    public Float getMeasuremin() {
        return measuremin;
    }

    public void setMeasuremin(Float measuremin) {
        this.measuremin = measuremin;
    }

    public Float getStartmin() {
        return startmin;
    }

    public void setStartmin(Float startmin) {
        this.startmin = startmin;
    }

    public Integer getHasprintedtotal() {
        return hasprintedtotal;
    }

    public void setHasprintedtotal(Integer hasprintedtotal) {
        this.hasprintedtotal = hasprintedtotal;
    }

    public Double getMenucost() {
        return menucost;
    }

    public void setMenucost(Double menucost) {
        this.menucost = menucost;
    }
}