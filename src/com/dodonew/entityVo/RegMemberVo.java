package com.dodonew.entityVo;

/**
 * Created by yukx on 17/5/5.
 */
public class RegMemberVo {
    private String storeId;
    private String nickNmae;
    private int sex;
    private String mobile;
    private Integer checkCode;
    private String birthday;
    private String unionId;
    private String openId;
    private String formId;

    @Override
    public String toString() {
        return "RegMemberVo{" +
                "storeId='" + storeId + '\'' +
                ", nickNmae='" + nickNmae + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", checkCode=" + checkCode +
                ", birthday='" + birthday + '\'' +
                ", unionId='" + unionId + '\'' +
                ", openId='" + openId + '\'' +
                ", formId='" + formId + '\'' +
                '}';
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getNickNmae() {
        return nickNmae;
    }

    public void setNickNmae(String nickNmae) {
        this.nickNmae = nickNmae;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(Integer checkCode) {
        this.checkCode = checkCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
