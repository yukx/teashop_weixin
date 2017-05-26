package com.dodonew.utils;

/**
 * Created by yukx on 17/4/13.
 */
public enum ErrorEnum {
    SUC(2000, "SUC"),                                       // 操作成功
    SIGN_ERROR(5003, "SIGN_ERROR"),                         // 签名错误
    PARAM_ERROR(5001, "PARAM_ERROR"),                       // 参数错误
    WXCHAT_ERROR(5004, "WXCHAT_ERROR"),                     // 调用微信接口异常
    SYSTEM_ERROR(5002, "SYSTEM_ERROR"),                     // 系统异常
    SESSION_NULL_ERROR(5005, "SESSION_NULL_ERROR"),         // session为空或失效
    ORDER_NULL_ERROR(5006, "ORDER_NULL_ERROR"),             // 订单为空
    ORDER_ISPAY(5007, "ORDER_ISPAY"),             // 订单已经支付
    ORDER_ISOVER(5008, "ORDER_ISOVER"),            // 订单已作废
    MEMBER_ISNULL(5009, "MEMBER_ISNULL"),           //会员不存在
    BALANCE_NOT_ENOUGH(5010, "BALANCE_NOT_ENOUGH"), //会员余额不足
    NOT_WX_ZFB(5011, "NOT_WX_ZFB"),          // 不是微信或者支付宝
    NAME_ISNULL(5012, "NAME_NOT_NULL"),   //会员名称为空
    MOBILE_ISNULL(5013, "MOBILE_NOT_NULL"),   //手机号为空
    UNIONID_ISNULL(5014, "UNIONID_ISNULL"),     // unionId为空
    CHECKCODE_ISNULL(5015, "CHECKCODE_ISNULL"), // 验证码为空
    CHECK_ERROR(5016, "CHECK_ERROR"),       // 验证码错误
    ORDER_REDPAY(5017, "ORDER_REDPAY"),       // 订单正在被其他人支付

    NO_DATA(6001, "NO_DATA"),//没有数据
    PV_USER_NULL(6002, "PV_USER_NULL"),//pv_user不存在
    SUBJECT_TYPE_NULL(6003, "SUBJECT_TYPE_NULL"),//支付方式不存在
    BILL_FAIL(6004, "BILL_FAIL"),//订单失败
    SE_STORE_NULL(6004, "SE_STORE_NULL");//门店不存在

    public static final String HWMD5KEY = "haowang_md5";

    private int code;
    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 普通方法
    public static String getMsg(int index) {
        for (ErrorEnum c : ErrorEnum.values()) {
            if (c.getCode() == index) {
                return c.msg;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
