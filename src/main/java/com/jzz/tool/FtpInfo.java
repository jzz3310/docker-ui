package com.jzz.tool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:jzz
 * @date:2020/12/11
 */
@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpInfo {
    private String ip;
    private String port;
    private String username;
    private String password;
}
