package com.dodonew.utils;

import com.dodonew.entityVo.DoPayVo;
import com.dodonew.entityVo.NotifyVo;
import jvc.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yukx on 17/4/22.
 */
public class DdnPayUtil {
    static Logger logger = Logger.getLogger(DdnPayUtil.class);

    private static final String notify_url = "https://yukx.ittun.com/haowangPay_api/order/notify.do";

    private static final String productId = "101";
    private static final String ddnUrl = "http://pay.dodonew.com/";
    private static final String ddnKey = "28j90ff3uksldj021802";
    private static final String ddnDesKey = "12345abc";
    private static final String ddnDesIv = "12345abc";

    /**
     * 下单
     *
     * @param doPayVo
     * @return
     */
    public static JSONObject unifiedorder(DoPayVo doPayVo) {

        SortedMap<String, String> map = new TreeMap<String, String>();
        map.put("productId", productId);
        map.put("relationStoreId", doPayVo.getStoreId());
        map.put("payType", doPayVo.getPayType());
        map.put("body", doPayVo.getStoreId());
        map.put("remark", doPayVo.getRemark());
        map.put("out_orderId", doPayVo.getOrderId());
        map.put("timestamp", getTimeStamp());
        map.put("nocestring", getNonceStr());
        map.put("notify_url", notify_url);
        map.put("bank", "CCB");
        if (!doPayVo.getPayType().equalsIgnoreCase("ZFB")) {
            map.put("payOpenId", doPayVo.getPayOpenId());
        }
        map.put("requestIp", doPayVo.getRequestIp());
        map.put("amount", doPayVo.getAmount() + "");

        String url = ddnUrl + "/pay/unifiedorder";
        logger.info("统一下单参数:" + map);
        try {
            /*MD5Utils.getPayOrderSign(map, ddnKey);
            JSONObject obj1 = JSONObject.fromObject(map);
            String encrypt = StringUtils.des64(obj1.toString(), ddnDesKey, ddnDesIv);
            map.clear();
            map.put("productId", productId);
            map.put("relationStoreId", doPayVo.getStoreId());
            map.put("Encrypt", URLEncoder.encode(encrypt, "utf-8"));
            JSONObject obj = JSONObject.fromObject(map);
            System.out.println(obj.toString());

            String rs = HttpUtil.httpPost(url, obj.toString(), 15000);
            logger.info("统一下单结果:" + rs);
            JSONObject json = JSONObject.fromObject(rs);*/
            return getJsonObject(doPayVo.getStoreId(), map, url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询订单状态
     * @param storeId
     * @param orderId
     * @return
     */
    public static boolean checkOrderStatus(String storeId, String orderId) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        map.put("productId", productId);
        map.put("relationStoreId", storeId);
        map.put("out_orderId", orderId);
        map.put("timestamp", getTimeStamp());
        map.put("nocestring", getNonceStr());
        String url = ddnUrl + "/pay/query";
        try {
            JSONObject result = getJsonObject(storeId, map, url);
            if (result == null) {
                return false;
            }
            if (!result.has("errcode") || result.getInt("errcode") != 0) {
                return false;
            }
            if (!result.has("data")) {
                return false;
            }
            JSONArray array = JSONArray.fromObject(result.getString("data"));
            if (array == null) {
                return false;
            }

            boolean con = false;
            for (int i = 0; i < array.size(); i++) {
                result = array.getJSONObject(i);
                if (!result.has("paycode")) {
                    continue;
                }
                int status = result.getInt("paycode");
                if (status == 1 || status == -2 || status == 2 || status == 3) {
                    con = true;
                    break;
                }
            }
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONObject getJsonObject(String storeId, SortedMap<String, String> map, String url) throws Exception {
        MD5Utils.getPayOrderSign(map, ddnKey);
        JSONObject obj1 = JSONObject.fromObject(map);
        String encrypt = StringUtils.des64(obj1.toString(), ddnDesKey, ddnDesIv);
        map.clear();
        map.put("productId", productId);
        map.put("relationStoreId", storeId);
        map.put("Encrypt", URLEncoder.encode(encrypt, "utf-8"));
        JSONObject obj = JSONObject.fromObject(map);

        String rs = HttpUtil.httpPost(url, obj.toString(), 15000);
        return JSONObject.fromObject(rs);
    }

    /**
     * 支付回调验证
     *
     * @param notifyVo
     * @return
     */
    public static boolean callBackCheck(NotifyVo notifyVo) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        map.put("transationId", notifyVo.getTransationId());
        map.put("ddnorderId", notifyVo.getDdnorderId());
        map.put("partnerOrderId", notifyVo.getPartnerOrderId());
        map.put("time", notifyVo.getTime());

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            sb.append(k + "=" + v + "&");
        }
        String mySign = sb.toString() + "key=" + ddnKey;
        mySign = MD5Utils.MD5Encode(mySign, "utf-8").toUpperCase();
        if (mySign.equalsIgnoreCase(notifyVo.getSign())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*DoPayVo doPayVo = new DoPayVo();
        doPayVo.setAmount(20000);
        doPayVo.setBody("8095835");
        doPayVo.setOrderId("8095835-1-151024190025");
        doPayVo.setPayOpenId("o-Ofs0Ny7jC6FzM9XBojD23IhOnM");
        doPayVo.setPayType("WXXCX");
        doPayVo.setStoreId("8095835");
        doPayVo.setRemark("8095835");
        doPayVo.setNotify_url("http://yukx.ittun.com/teashop_api/dodonewPay.jsp");

        JSONObject object = DdnPayUtil.unifiedorder(doPayVo);
        System.out.println(object);*/

        System.out.println(checkOrderStatus("MD_87803250", "MD_87803250-1178-11551"));
    }

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getNonceStr() {
        Random random = new Random();
        return MD5Utils.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
    }
}
