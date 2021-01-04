package com.jzz.util;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import com.jzz.pojo.UiDocker;


/**
 * @author:jzz
 * @date:2020/12/12
 */
public class DockerClientUtil {

    /**
     * 连接docker服务器
     * @return
     */
    private static DockerClient safetyConnection(UiDocker uiDocker){
        //进行安全认证
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(true)
                .withDockerCertPath(uiDocker.getCertPath()).withDockerHost("tcp://"+uiDocker.getDockerIp()+":"+uiDocker.getDockerPort())
                .withDockerConfig(uiDocker.getCertPath()).withApiVersion(uiDocker.getVersionApi()).withRegistryUrl(uiDocker.getRegisterUrl())
                .withRegistryUsername(uiDocker.getDockerName()).withRegistryPassword(uiDocker.getDockerPwd())
                .withRegistryEmail(uiDocker.getRegisterEmail()).build();
        DockerCmdExecFactory dockerCmdExecFactory =  new JerseyDockerCmdExecFactory()
                .withReadTimeout(1000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);
        //进行连接
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
        return dockerClient;
    }

    public static DockerClient connect(UiDocker uiDocker){
        //未进行安全认证
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(false)
                .withDockerHost("tcp://"+uiDocker.getDockerIp()+":"+uiDocker.getDockerPort())
                .withApiVersion(uiDocker.getVersionApi()).withRegistryUrl(uiDocker.getRegisterUrl())
                .withRegistryUsername(uiDocker.getDockerName()).withRegistryPassword(uiDocker.getDockerPwd())
                .withRegistryEmail(uiDocker.getRegisterEmail()).build();
        DockerCmdExecFactory dockerCmdExecFactory =  new JerseyDockerCmdExecFactory()
                .withReadTimeout(1000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);
        //进行连接
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
        return dockerClient;
    }

    public static void main(String[] args) {
        UiDocker uiDocker = new UiDocker();
        uiDocker.setDockerIp("42.192.120.164");
        uiDocker.setDockerPort(2375);
        uiDocker.setCertPath("F:/docker/");
        DockerClient dockerClient = DockerClientUtil.safetyConnection(uiDocker);
        System.out.println(dockerClient.listImagesCmd().exec());


    }
}
