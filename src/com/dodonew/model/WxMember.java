package com.dodonew.model;


public class WxMember{
    private Integer memberid;

    private String nickname;

    private String openid;

    private String mobile;

    private Integer gender;

    private String registtime;

    private String storeid;

    private String cardid;

    private String membername;

    private double balance;

    private Integer mycredits;

    private String accountnumber;

    private Float lastbalance;

    private String cardlevelid;

    private Integer cardstatus;

    private String canceltime;

    private String operator;

    private Integer mygrowthvalue;

    private String memberbirthday;

    private String tempmobile;

    private Byte isfirstattention;

    private String idcard;

    private String birthday;

    private String password;

    private String extendid;

    private Integer batchid;

    private Double givemoney;

    private Byte ispwd;

    private String unionId;

    private Integer memberCardId;


    // 用于分页参数
    private int pageNo;
    private int pageSize;

    @Override
    public String toString() {
        return "WxMember{" +
                "memberid=" + memberid +
                ", nickname='" + nickname + '\'' +
                ", openid='" + openid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", registtime='" + registtime + '\'' +
                ", storeid='" + storeid + '\'' +
                ", cardid='" + cardid + '\'' +
                ", membername='" + membername + '\'' +
                ", balance=" + balance +
                ", mycredits=" + mycredits +
                ", accountnumber='" + accountnumber + '\'' +
                ", lastbalance=" + lastbalance +
                ", cardlevelid='" + cardlevelid + '\'' +
                ", cardstatus=" + cardstatus +
                ", canceltime='" + canceltime + '\'' +
                ", operator='" + operator + '\'' +
                ", mygrowthvalue=" + mygrowthvalue +
                ", memberbirthday='" + memberbirthday + '\'' +
                ", tempmobile='" + tempmobile + '\'' +
                ", isfirstattention=" + isfirstattention +
                ", idcard='" + idcard + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", extendid='" + extendid + '\'' +
                ", batchid=" + batchid +
                ", givemoney=" + givemoney +
                ", ispwd=" + ispwd +
                ", unionId='" + unionId + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(Integer memberCardId) {
        this.memberCardId = memberCardId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime;
    }

    public String getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(String canceltime) {
        this.canceltime = canceltime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getMycredits() {
        return mycredits;
    }

    public void setMycredits(Integer mycredits) {
        this.mycredits = mycredits;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber == null ? null : accountnumber.trim();
    }

    public Float getLastbalance() {
        return lastbalance;
    }

    public void setLastbalance(Float lastbalance) {
        this.lastbalance = lastbalance;
    }

    public String getCardlevelid() {
        return cardlevelid;
    }

    public void setCardlevelid(String cardlevelid) {
        this.cardlevelid = cardlevelid == null ? null : cardlevelid.trim();
    }

    public Integer getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(Integer cardstatus) {
        this.cardstatus = cardstatus;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getMygrowthvalue() {
        return mygrowthvalue;
    }

    public void setMygrowthvalue(Integer mygrowthvalue) {
        this.mygrowthvalue = mygrowthvalue;
    }

    public String getMemberbirthday() {
        return memberbirthday;
    }

    public void setMemberbirthday(String memberbirthday) {
        this.memberbirthday = memberbirthday == null ? null : memberbirthday.trim();
    }

    public String getTempmobile() {
        return tempmobile;
    }

    public void setTempmobile(String tempmobile) {
        this.tempmobile = tempmobile == null ? null : tempmobile.trim();
    }

    public Byte getIsfirstattention() {
        return isfirstattention;
    }

    public void setIsfirstattention(Byte isfirstattention) {
        this.isfirstattention = isfirstattention;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getExtendid() {
        return extendid;
    }

    public void setExtendid(String extendid) {
        this.extendid = extendid == null ? null : extendid.trim();
    }

    public Integer getBatchid() {
        return batchid;
    }

    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    public Double getGivemoney() {
        return givemoney;
    }

    public void setGivemoney(Double givemoney) {
        this.givemoney = givemoney;
    }

    public Byte getIspwd() {
        return ispwd;
    }

    public void setIspwd(Byte ispwd) {
        this.ispwd = ispwd;
    }
}