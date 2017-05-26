package com.dodonew.controller;

import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.HttpUtil;
import com.dodonew.utils.MD5Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yukx on 17/4/17.
 */

public class ExampleControllerTest {
    private final static String url = "http://localhost:8080/haowangPay_api";

    @Before
    public void before(){

    }

    @Test
    public void testQueryByPage() throws Exception {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("pageNo", "1");
        map.put("pageSize", "12");
        String paramStr = MD5Utils.signMap(map, ErrorEnum.HWMD5KEY);
        String result = HttpUtil.httpPost(url+"/example/queryByPage.do", paramStr, 15000);
        System.out.println(result);
    }

    @Test
    public void testHello() throws Exception {
        //System.out.println("hello");
        int a[]={1,2,3,4,6,7,8,9,10};
        System.out.println(a[8]);
    }
}