package com.dodonew.utils;

import com.google.common.base.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by maxiao on 2017/4/25.
 */
public class Mutils {

    public static boolean isNotBlank(String ... args){

        for (String arg:
             args) {

            if(Strings.isNullOrEmpty(arg)){
                return  false;
            }
        }

        return  true;
    }

    public static boolean isBlank(String ... args){

        return  !isNotBlank(args);
    }



    public static boolean isNotBlankArray(String[] ... args){

        for (String[] arg:
                args) {

            if(arg == null || arg.length == 0 ){
                return  false;
            }
        }

        return  true;
    }

    public static boolean isBlankArray(String[] ... args){

        for (String[] arg:
                args) {

            if(arg == null || arg.length == 0 ){
                return  true;
            }
        }

        return  false;
    }


    public static String getFixLengthString(int strLength) {

        Random rm = new Random();

        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        String fixLengthString = String.valueOf(pross);

        return fixLengthString.substring(1, strLength + 1);
    }

    public static  String getBillId(String storeId){

        StringBuffer sb = new StringBuffer();
        sb.append(storeId);
        sb.append("-");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        sb.append( sdf.format(new Date()));
        sb.append("-");
        sb.append(getFixLengthString(4));

        return sb.toString();
    }
}
