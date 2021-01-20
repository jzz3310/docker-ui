package com.jzz.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:jzz
 * @date:2021/1/15
 */
@Data
@Component
@ConfigurationProperties(prefix = "my.test")
public class MyTest {

    public String name;
    public String password;

}
