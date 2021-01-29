package com.jzz.util;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import com.jzz.pojo.UiDocker;
import com.jzz.tool.DockerExec;
import com.jzz.tool.ImageVo;

import java.util.List;


/**
 * @author:jzz
 * @date:2020/12/12
 */
public class DockerClientUtil {

    /**
     * 连接docker服务器
     * @return
     */
    public static DockerExec safetyConnection(UiDocker uiDocker){
        //进行安全认证
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(true)
                .withDockerCertPath(OSUtil.getCertPath()+uiDocker.getDockerIp()).withDockerHost("tcp://"+uiDocker.getDockerIp()+":"+uiDocker.getDockerPort())
                .withDockerConfig(OSUtil.getCertPath()+uiDocker.getDockerIp()).withApiVersion(uiDocker.getVersionApi()).withRegistryUrl(uiDocker.getRegisterUrl())
                .withRegistryUsername(uiDocker.getDockerName()).withRegistryPassword(uiDocker.getDockerPwd())
                .withRegistryEmail(uiDocker.getRegisterEmail()).build();
        DockerCmdExecFactory dockerCmdExecFactory =  new JerseyDockerCmdExecFactory()
                .withReadTimeout(5000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);
        //进行连接
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
        DockerExec dockerExec = new DockerExec();
        dockerExec.setDockerClient(dockerClient);
        return dockerExec;
    }

    public DockerExec connect(UiDocker uiDocker){
        //未进行安全认证
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(false)
                .withDockerHost("tcp://"+uiDocker.getDockerIp()+":"+uiDocker.getDockerPort())
                .withApiVersion(uiDocker.getVersionApi()).withRegistryUrl(uiDocker.getRegisterUrl())
                .withRegistryUsername(uiDocker.getDockerName()).withRegistryPassword(uiDocker.getDockerPwd())
                .withRegistryEmail(uiDocker.getRegisterEmail()).build();
        DockerCmdExecFactory dockerCmdExecFactory =  new JerseyDockerCmdExecFactory()
                .withReadTimeout(5000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);
        //进行连接
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
        DockerExec dockerExec = new DockerExec();
        dockerExec.setDockerClient(dockerClient);
        return dockerExec;
    }


    public static void main(String[] args) throws InterruptedException {
        UiDocker uiDocker = new UiDocker();
        uiDocker.setDockerIp("42.192.120.164");
        uiDocker.setDockerPort(2375);
        DockerExec dockerClient = DockerClientUtil.safetyConnection(uiDocker);
        List<ImageVo> imageVos = dockerClient.listImages();
        System.out.println(imageVos.size());

        dockerClient.pullImage("docker.io/mongo");


    }
}
