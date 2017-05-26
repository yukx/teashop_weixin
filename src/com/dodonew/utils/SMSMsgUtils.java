package com.dodonew.utils;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;

/**
 * Created by yukx on 17/5/5.
 */
public class SMSMsgUtils {
    private static final String un="N8930831";
    private static final String pw="c44b136b";
    private static final String send_url = "http://sms.253.com/msg/";

    /**
     * 发送短信
     *
     * @param phone
     * @param msg
     * @return
     * @throws Exception
     */
    public static String sendMessage(String phone, String msg) throws Exception {
        HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
        GetMethod method = new GetMethod();
        try {
            URI base = new URI(send_url, false);
            method.setURI(new URI(base, "send", false));
            method.setQueryString(new NameValuePair[]{
                    new NameValuePair("un", un),
                    new NameValuePair("pw", pw),
                    new NameValuePair("phone", phone),
                    new NameValuePair("rd", "1"),
                    new NameValuePair("msg", msg),
                    new NameValuePair("ex", null),
            });
            int result = client.executeMethod(method);
            if (result == HttpStatus.SC_OK) {
                InputStream in = method.getResponseBodyAsStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                return URLDecoder.decode(baos.toString(), "UTF-8");
            } else {
                throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
            }
        } finally {
            method.releaseConnection();
        }
    }

    /**
     * 发送短信
     *
     * @throws Exception
     */
    public static String sendSMS(final String pszMobis, final String pszMsg) {
        try {
            String res = sendMessage(pszMobis, "【嘟嘟牛】" + pszMsg);
            //System.out.println(pszMobis + "【云通讯返回】" + res);
            return res;
        } catch (Exception e) {
            System.out.println(pszMobis + "【云通讯异常】" + e);
            return null;
        }
    }

    public static void main(String[] args) {
        sendSMS("17727840617", "你的验证码为:"+1234);
    }

}
