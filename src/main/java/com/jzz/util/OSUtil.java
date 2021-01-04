package com.jzz.util;

import java.util.Properties;

/**
 * @author:jzz
 * @date:2020/12/11
 */
public class OSUtil {

    public static String getCertPath () {
        String path = "";
        //获取操作系统版本
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        if (name.toLowerCase().contains("windows")) {
            path = "D:/docker/";
        } else if (name.toLowerCase().contains("linux")) {
            path = "/data/ftp/data/admin/certs/";
        } else if (name.toLowerCase().contains("mac")) {
            path = "D:/docker/";
        }
        return path;
    }

    public static boolean isLinux () {
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        if (name.toLowerCase().contains("linux")) {
            return true;
        } else {
            return false;
        }
    }


}
