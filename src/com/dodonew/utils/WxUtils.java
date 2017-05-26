package com.dodonew.utils;

import com.dodonew.entityVo.SendModelVo;
import com.dodonew.model.WxPayOrderInfo;
import jvc.util.CacheUtils;
import jvc.util.DateUtils;
import jvc.util.NetUtils;
import jvc.util.StringUtils;
import net.sf.json.JSONObject;

/**
 * Created by yukx on 17/4/21.
 */
public class WxUtils {
    public static final String appId = "wx2972fce28f00a5ce";
    public static final String secret = "503e62f4acfc98a7bcc14f055a20542b";
    private static final String session_key_url = "https://api.weixin.qq.com/sns/jscode2session";

    public static final String XFTZ_MODEL = "iSxeF1oFWsN8mJtm-hkpW0fQyqnBw2HpnFaKD9sW6jc";       // 消费通知
    public static final String NXFTZ_MODEL = "W739lJ3-Fdw7vCl58k-LqMo_oLrpDTHs-OBiqz6J-ZU";       // 消费通知2
    public static final String ZCTZ_MODEL = "HiEXPbCKin_pMOdICsLOnSGlqr37cgxKhsdNScW-FGY";       // 注册成功通知


    /**
     * code 换取 session_key/openId
     *
     * @param code
     * @return
     */
    public static JSONObject jscode2session(String code) {
        try {
            String result = NetUtils.getHtmlSource(session_key_url + "?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code", 10000);
            return JSONObject.fromObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取access_token
     *
     * @return
     */
    public static String getAccess_token() {
        String access_token = CacheUtils.getString(appId + "access_token");
        if (StringUtils.isBlank(access_token)) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
            try {
                String rs = HttpUtil.httpGet(url, 5000);
                if (StringUtils.isBlank(rs)) {
                    return null;
                }
                JSONObject object = JSONObject.fromObject(rs);
                if (object == null) {
                    return null;
                }
                if (object.has("access_token")) {
                    access_token = object.getString("access_token");
                    long time = object.has("expires_in") ? object.getLong("expires_in") : 0;
                    if (time == 0) {
                        time = 7200;  // 2小时
                    }
                    CacheUtils.put(appId + "access_token", (time - 300) * 1000);        // 缓存以毫秒为单位,提前5分钟
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return access_token;
    }

    public static String sendModel(String access_token, SendModelVo sendModelVo) {
        if (StringUtils.isBlank(access_token) || sendModelVo == null) {
            return null;
        }
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + access_token;
        String rs = NetUtils.getHtmlSourcePost(url, sendModelVo.toString());
        return rs;
    }

    public static JSONObject newJSONDATA(String value, String color) {
        JSONObject object = new JSONObject();
        object.put("value", value);
        if (StringUtils.isNotBlank(color)) {
            object.put("color", color);
        }
        return object;
    }


    public static String checkOrder(WxPayOrderInfo wxPayOrderInfo) {
        int code;
        if (wxPayOrderInfo == null) {
            code = ErrorEnum.ORDER_NULL_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (wxPayOrderInfo.getStatus() == 1) {
            code = ErrorEnum.ORDER_ISPAY.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (wxPayOrderInfo.getStatus() == 10) {
            code = ErrorEnum.ORDER_ISOVER.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        return null;
    }


    public static void main(String[] args) {
        //System.out.println(jscode2session("001FpWzb136Qtr02lSyb1O6Dzb1FpWzX"));
        //System.out.println(getAccess_token());
        SendModelVo sendModelVo = new SendModelVo();
        sendModelVo.setTouser("o-Ofs0Ny7jC6FzM9XBojD23IhOnM");
        sendModelVo.setTemplate_id(WxUtils.XFTZ_MODEL);

        JSONObject object = new JSONObject();
        object.put("keyword1", newJSONDATA("测试门店", null));
        object.put("keyword2", newJSONDATA("8095835-1-151024190025", null));
        object.put("keyword3", newJSONDATA("123456", null));
        object.put("keyword4", newJSONDATA("100", null));
        object.put("keyword5", newJSONDATA(DateUtils.now("yyyy-MM-dd HH:mm:ss"), null));
        object.put("keyword6", newJSONDATA("80", null));

        sendModelVo.setForm_id("f6c87a7bfff6631b002e30d69471a2f8");

        sendModelVo.setData(object);

        String access_token = getAccess_token();
        System.out.println(sendModelVo.toString());
        System.out.println(sendModel(access_token, sendModelVo));
    }
}
