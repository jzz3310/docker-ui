package com.jzz.util;

import com.jzz.bean.FtpBean;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author:jzz
 * @date:2020/12/11
 */
@Component
public class FileUtil {

    public static String uploadFtp(String dockerIp, InputStream inputStream, String filename) throws Exception {
        FTPClient ftp = FtpBean.connect();
        String path = HostIpUtil.getIp(dockerIp);
        try {
            if (!ftp.changeWorkingDirectory("/cert/"+path)) {
                ftp.makeDirectory("/cert/"+path);
            }
            ftp.changeWorkingDirectory("/cert/"+path);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.storeFile(filename, inputStream);
        } catch (IOException e) {
//            throw new MyException(ResultEnum.UPLOAD_FTP_FAILD);
            e.printStackTrace();
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
                new Exception("连接ftp服务器失败，请检查网络以及相关配置").printStackTrace();
            }
        } catch (IOException e) {
            try {
                ftp.disconnect();
            } catch (IOException ioException) {
                new Exception("连接ftp服务器失败，请检查网络以及相关配置").printStackTrace();
            }
            new Exception("连接ftp服务器失败，请检查网络以及相关配置").printStackTrace();
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
            e.printStackTrace();
            return "";
        } finally {
            inputStream.close();
            out.close();
        }
        return OSUtil.getCertPath();
    }

}
