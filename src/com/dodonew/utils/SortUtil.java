package com.dodonew.utils;

import java.util.Arrays;

/**
 * Created by yukx on 17/4/21.
 */
public class SortUtil {
    /**
     *
     * @return
     */
    public static String dictiondrySort(String... tmpArr) {
        Arrays.sort(tmpArr);
        String tmpStr = arrayToString(tmpArr);
        return tmpStr;
    }

    private static String arrayToString(String[] arr) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            bf.append(arr[i]);
        }
        return bf.toString();
    }
}
