package com.jzz.util;

import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author:jzz
 * @date:2020/12/15
 */
public class HostIpUtil {

    public static String getIp(String ip) throws MyException {
        if (ip.matches("^((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))$")) {
            return ip;
        }
        try {
            InetAddress[] allByName = InetAddress.getAllByName(ip);
            return allByName[0].getHostAddress();
        } catch (UnknownHostException e) {
            throw new MyException(ResultEnum.HOST_IP_ERROR);
        }
    }
}
