package com.jzz.bean;

import com.jzz.tool.FtpInfo;
import com.jzz.util.FileUtil;
import info.xiancloud.core.util.LOG;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
                log.error("连接失败",e);
            }
        }
    }

}
