package com.jzz;

import com.jzz.util.HostIpUtil;
import com.sun.deploy.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

/**
 * @author:jzz
 * @date:2020/12/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("127.0.0.1");
        Object ftp = boundHashOperations.entries().get("ftp");
        System.out.println(ftp);
    }
}





