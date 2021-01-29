package com.jzz.util;

import java.util.Properties;

/**
 * @author:jzz
 * @date:2020/12/11
 */
public class OSUtil {

    public static String getCertPath () {
        String path = "";
        if (isLinux()) {
            path = "/root/certs/";
        } else {
            path = "F:/docker/certs/";
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

    public static String getSecret () {
        String path = "";
        if (isLinux()) {
            path = "/root/secret/";
        } else {
            path = "F:/docker/secret/";
        }
        return path;
    }


}
