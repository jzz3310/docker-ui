package com.jzz.util;

import com.jzz.bean.FtpBean;
import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * @author:jzz
 * @date:2020/12/11
 */
@Slf4j
public class FileUtil {

    public static String uploadFtp(String dockerIp, InputStream inputStream, String filename) throws Exception {
        FTPClient ftp = FtpBean.connect();
        String path = HostIpUtil.getIp(dockerIp);
        try {
            if (!ftp.changeWorkingDirectory("/certs/"+path)) {
                ftp.makeDirectory("/certs/"+path);
            }
            ftp.changeWorkingDirectory("/certs/"+path);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.storeFile(filename, inputStream);
        } catch (IOException e) {
            log.error("ftp上传文件失败",e);
            throw new MyException(ResultEnum.UPLOAD_FTP_FAILD);
        } finally {
            FtpBean.disConnect(ftp);
        }
        return OSUtil.getCertPath()+dockerIp;
    }

    public static FTPClient connectFtp (String ip, String port, String username, String password) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.enterLocalPassiveMode();
            ftp.setBufferSize(1024);
            ftp.setControlEncoding("utf-8");
            ftp.setConnectTimeout(1000 * 30);//设置连接超时时间
            ftp.connect(ip, Integer.parseInt(port));
            ftp.login(username, password);
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                log.error("ftp连接失败");
                throw new MyException(ResultEnum.FTP_FAILED);
            }
        } catch (IOException e) {
            try {
                ftp.disconnect();
            } catch (IOException ioException) {
                throw new MyException(ResultEnum.FTP_FAILED);
            }
            throw new MyException(ResultEnum.FTP_FAILED);
        }
        return ftp;
    }

    public static String uploadLocal (String dockerIp, InputStream inputStream, String filename) throws IOException {
        File file = new File(OSUtil.getCertPath()+ dockerIp + "/" + filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream out = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        try {
            while (inputStream.read(bytes) > 0) {
                out.write(bytes);
            }
        } catch (IOException e) {
            log.error("上传文件到本地失败");
            throw e;
        } finally {
            inputStream.close();
            out.close();
        }
        return OSUtil.getCertPath();
    }

}
