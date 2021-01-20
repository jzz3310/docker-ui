package com.jzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzz.data.ResponseData;
import com.jzz.pojo.UiDocker;
import com.jzz.tool.DockerExec;
import com.jzz.tool.MyException;

/**
 * @author:jzz
 * @date:2020/12/29
 */
public interface UiDockerService extends IService<UiDocker> {
    ResponseData connect(UiDocker uiDocker) throws MyException;

    ResponseData register(UiDocker uiDocker) throws MyException;

    UiDocker getDockerByUserId(String userId);

    DockerExec getClient(String userId);

}
