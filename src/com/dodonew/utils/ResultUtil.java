package com.dodonew.utils;

import net.sf.json.JSONObject;

/**
 * Created by yukx on 17/4/13.
 */
public class ResultUtil {


    public static String resultJson(int code, String message, Object object){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", object);
        return jsonObject.toString();
    }

    public static String errorJson(int code, String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        return jsonObject.toString();
    }
}
