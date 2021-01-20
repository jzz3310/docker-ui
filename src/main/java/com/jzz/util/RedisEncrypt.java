package com.jzz.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConfiguration;

import javax.sql.DataSource;

/**
 * @author:jzz
 * @date:2021/1/13
 */
@Aspect
@Configuration
public class RedisEncrypt {

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Autowired
    private RedisProperties redisProperties;


    @Before("execution(* org.springframework.boot.autoconfigure.data.redis.RedisProperties.getPassword())")
    public void redisPassword () {
        redisProperties.setPassword(AesEncryptUtils.decrypt(redisPassword));
    }






}
