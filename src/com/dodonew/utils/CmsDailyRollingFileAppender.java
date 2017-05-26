package com.dodonew.utils;

import org.apache.log4j.FileAppender;
import org.apache.log4j.helpers.LogLog;

import java.io.*;

/**
 * Created by yukx on 17/4/12.
 */
public class CmsDailyRollingFileAppender extends FileAppender {
    boolean copy(File src, File dst) throws IOException {
        try {
            InputStream in = new FileInputStream(src);

            OutputStream out = new FileOutputStream(dst);

            // Transfer bytes from in to out
            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            return true;
        } catch (FileNotFoundException e) {
            LogLog.error("源文件不存在,或者目标文件无法被识别." );
            return false;
        } catch (IOException e) {
            LogLog.error("文件读写错误.");
            return false;
        }
    }
}
