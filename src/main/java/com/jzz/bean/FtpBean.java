package com.jzz.bean;

import com.jzz.tool.FtpInfo;
import com.jzz.util.FileUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author:jzz
 * @date:2020/12/11
 */
@Component
public class FtpBean {

    private static FtpInfo ftpInfo;

    @Autowired
    public void initFtpInfo (FtpInfo ftp) {
        ftpInfo = ftp;
    }

    public static FTPClient connect () {
        FTPClient ftpClient = FileUtil.connectFtp(ftpInfo.getIp(), ftpInfo.getPort(), ftpInfo.getUsername(), ftpInfo.getPassword());
        return ftpClient;
    }

    public static void disConnect (FTPClient ftpClient) {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
            }
        }
    }

}
