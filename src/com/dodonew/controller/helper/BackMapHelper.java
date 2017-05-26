package com.dodonew.controller.helper;

import com.dodonew.utils.ErrorEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maxiao on 2017/3/28.
 */
public class BackMapHelper {



    public static Map<String,Object> backSuccess(String message){
        Map<String,Object> params = new HashMap<String ,Object>();
        params.put("code", ErrorEnum.SUC.getCode());
        params.put("msg", ErrorEnum.SUC.getMsg());

        return  params;
    }

    public static  Map<String,Object> backSuccess(){
        return  backSuccess("操作成功！");
    }


    public static  Map<String,Object> back(ErrorEnum errorEnum){

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("code",errorEnum.getCode());
        params.put("msg",errorEnum.getMsg());

        return  params;
    }

    public static Map<String,Object> backError(String message){
        Map<String,Object> params = new HashMap<String ,Object>();
        params.put("code", ErrorEnum.SYSTEM_ERROR.getCode());
        params.put("msg",ErrorEnum.SYSTEM_ERROR.getMsg());

        return  params;
    }

    public static  Map<String,Object> backError(){
        return  back(ErrorEnum.SYSTEM_ERROR);
    }

    public static Map<String,Object> backData(Object data){

        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", ErrorEnum.SUC.getCode());
        res.put("msg",ErrorEnum.SUC.getMsg());
        res.put("data",data);

        return res;
    }

}
