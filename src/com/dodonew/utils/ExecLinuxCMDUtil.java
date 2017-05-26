package com.dodonew.utils;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * java在linux环境下执行linux命令，然后返回命令返回值。  用户生成sessionkey
 * Created by yukx on 17/4/22.
 */
public class ExecLinuxCMDUtil {
    public static final  ExecLinuxCMDUtil instance = new ExecLinuxCMDUtil();

    public static Object exec(String cmd) {
        try {
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ExecLinuxCMDUtil.instance.exec("cat /dev/urandom |od -x | tr -d ' '| head -n 1").toString();
    }
}
