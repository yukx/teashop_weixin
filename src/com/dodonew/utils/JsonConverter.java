package com.dodonew.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maxiao on 2017/4/28.
 */
public class JsonConverter extends GsonHttpMessageConverter {

    /**
     * 排除String
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {

        if( clazz == null || clazz.equals(String.class))return  false;
        return super.canWrite(clazz, mediaType);
    }


    public JsonConverter(){
        //更换Gson转换器
        super.setGson(new GsonBuilder().disableHtmlEscaping()
                .setDateFormat("yyyy-MM-dd HH:mm:ss") //设置日期转换
                .create());
    }



    public static void main(String[] args) {

       Gson f =  new GsonBuilder().disableHtmlEscaping().enableComplexMapKeySerialization().setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm:ss") //设置日期转换
                .create();


        Map params = new HashMap();
        params.put("data","sxxals");
        System.out.println(String.class);

        System.out.println(f.toJson(f.toJson(params)));
    }
}
