package com.dodonew.utils;

import java.security.MessageDigest;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yukx on 17/4/14.
 */
public class MD5Utils {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    public static String signMap(SortedMap<String, String> map, String key) {
        String str = "";
        String result = "";
        for (Map.Entry<String, String> obj : map.entrySet()) {
            str += obj.getKey() + "=" + obj.getValue() + "&";
            result += obj.getKey() + "=" + obj.getValue() + "&";
        }
        str += "key=" + key;//ErrorEnum.HWMD5KEY;
        String sign = MD5Encode(str, "utf-8");
        result += "sign=" + sign;
        return result;
    }

    /***
     * 获取支付下订单sign
     * @param signParams
     * @param partner_key
     * @return
     * @throws Exception
     */
    public static Map<String, String> getPayOrderSign(SortedMap<String, String> signParams , String partner_key) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry:  signParams.entrySet()) {

            String k =  entry.getKey();
            String v =  entry.getValue();
            sb.append(k + "=" + v + "&");
            //要采用URLENCODER的原始值！
        }
        String params = sb.toString()+"key="+partner_key;
        params = MD5Encode(params, "utf-8").toUpperCase();
        signParams.put("sign", params);//这就是需要sign
        return signParams;
    }


    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static void main(String[] args) {
        /*SortedMap<String, String> map = new TreeMap<>();
        map.put("c", "21");
        map.put("a", "1");
        map.put("b", "33");
        System.out.println(signMap(map, ErrorEnum.HWMD5KEY));*/

        System.out.println(MD5Encode("123456","utf-8"));
    }

}
