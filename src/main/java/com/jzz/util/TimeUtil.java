package com.jzz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:jzz
 * @date:2020/12/29
 */
public class TimeUtil {

    public static String now () {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = simpleDateFormat.format(new Date());
        return datetime;
    }
}
