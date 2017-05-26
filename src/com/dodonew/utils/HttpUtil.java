package com.dodonew.utils;

import jvc.util.LogUtils;

import javax.servlet.ServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yukx on 17/4/18.
 */
public class HttpUtil {

    public static final String ISWEIXIN = "MicroMessenger";
    public static final String ISZFB = "AlipayClient";

    private static final int timeout = 5000;
    private static final String encode = "utf-8";
    public static final boolean IS_JAVA_1_4 = getJavaVersionMatches("1.4");

    private static boolean getJavaVersionMatches(final String versionPrefix) {
        return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix);
    }

    public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");

    private static String getSystemProperty(final String property) {
        try {
            return System.getProperty(property);
        } catch (final SecurityException ex) {
            // we are not allowed to look at this property
            System.err.println("Caught a SecurityException reading the system property '" + property
                    + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    static boolean isJavaVersionMatch(final String version, final String versionPrefix) {
        if (version == null) {
            return false;
        }
        return version.startsWith(versionPrefix);
    }

    public static String getParams(ServletRequest request){
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    /***
     * 普通HTTP POST请求
     *
     * @param mainUrl
     * @param params
     * @param timeout
     * @return
     * @throws Exception
     */
    public static String httpPost(String mainUrl, String params, int timeout) throws Exception {
        if (timeout < 1)
            timeout = timeout;

        InputStream in = null;
        BufferedReader rd = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(mainUrl);

            conn = (HttpURLConnection) url.openConnection();//建立连接
            conn.setRequestMethod("POST");//Default is GET
            conn.setRequestProperty("Accept-Charset", encode);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (IS_JAVA_1_4) {
                System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(timeout));//（单位：毫秒）jdk1.4换成这个,连接超时
                System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(timeout));//读 超时
            } else {
                conn.setConnectTimeout(timeout);//连接主机超时 单位毫秒
                conn.setReadTimeout(timeout);//从主机读取数据超时 单位毫秒
            }
            conn.setUseCaches(false);//不使用缓存
            conn.setDoOutput(true);//因为post请求参数写在正文，故true
            // byte[] b = params.toString().getBytes();
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out.write(params);
            out.flush();
            out.close();

            in = conn.getInputStream();//发送请求
            rd = new BufferedReader(new InputStreamReader(in, encode));//获得输入流
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            String respContent = tempStr.toString();
            return respContent;
        } catch (Exception e) {
            LogUtils.error("POST请求异常" + e.getMessage());
        } finally {
            if (rd != null)
                rd.close();
            if (in != null)
                in.close();
            if (conn != null)
                conn.disconnect();
        }

        return "";

    }


    public static String httpGet(String mainUrl, int timeout) throws Exception {
        if (timeout < 1)
            timeout = timeout;

        InputStream in = null;
        BufferedReader rd = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(mainUrl);

            conn = (HttpURLConnection) url.openConnection();//建立连接
            conn.setRequestMethod("GET");//Default is GET
            conn.setRequestProperty("Accept-Charset", encode);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (IS_JAVA_1_4) {
                System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(timeout));//（单位：毫秒）jdk1.4换成这个,连接超时
                System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(timeout));//读 超时
            } else {
                conn.setConnectTimeout(timeout);//连接主机超时 单位毫秒
                conn.setReadTimeout(timeout);//从主机读取数据超时 单位毫秒
            }
            conn.setUseCaches(false);//不使用缓存
            conn.connect();// 建立实际的连接
            in = conn.getInputStream();//发送请求
            rd = new BufferedReader(new InputStreamReader(in, encode));//获得输入流
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            String respContent = tempStr.toString();
            return respContent;
        } catch (Exception e) {
            LogUtils.error("GET请求异常" + e.getMessage());
        } finally {
            if (rd != null)
                rd.close();
            if (in != null)
                in.close();
            if (conn != null)
                conn.disconnect();
        }

        return "";
    }


}
