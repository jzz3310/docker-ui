package com.jzz;

import com.github.dockerjava.api.DockerClient;
import com.jzz.pojo.UiDocker;
import com.jzz.tool.DockerExec;
import com.jzz.tool.EncryptionByMD5;
import com.jzz.util.DockerClientUtil;
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
import org.springframework.util.ObjectUtils;

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

    @Test
    public void test2 () {
        UiDocker uiDocker = new UiDocker();
        uiDocker.setDockerIp("42.192.120.164");
        uiDocker.setDockerPort(2375);
        uiDocker.setCertPath("F:/docker/");
        DockerExec connect = DockerClientUtil.safetyConnection(uiDocker);
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(EncryptionByMD5.getMD5("123" + "dockerclient"));
        if (null == boundValueOperations.get()) {
            boundValueOperations.set(connect.toString());
        } else {
            DockerClient a = (DockerClient) boundValueOperations.get();
            System.out.println(a);
        }
    }
}





