package com.jzz.bean;

import com.github.dockerjava.api.DockerClient;
import com.jzz.tool.DockerExec;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jzz
 * @date:2021/1/14
 */
@Component
public class DockerClientBeans {
    private static final Map<String, DockerExec> beans = new HashMap<String, DockerExec>() ;

    public void addClient (String name, DockerExec dockerExec) {
        beans.put(name, dockerExec);
    }

    public DockerExec get (String name) {
        DockerExec dockerClient = beans.get(name);
        return dockerClient;
    }


}
