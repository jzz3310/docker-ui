package com.jzz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.dockerjava.api.DockerClient;
import com.jzz.bean.DockerClientBeans;
import com.jzz.data.ResponseData;
import com.jzz.mapper.UiDockerMapper;
import com.jzz.mapper.UiUserMapper;
import com.jzz.pojo.UiDocker;
import com.jzz.pojo.UiUser;
import com.jzz.service.UiDockerService;
import com.jzz.tool.DockerExec;
import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;
import com.jzz.util.DockerClientUtil;
import com.jzz.util.HostIpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:jzz
 * @date:2020/12/29
 */
@Service
public class UiDockerServiceImpl extends ServiceImpl<UiDockerMapper,UiDocker> implements UiDockerService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UiUserMapper uiUserMapper;
    @Autowired
    private DockerClientBeans clientBeans;

    @Override
    public ResponseData connect(UiDocker uiDocker) throws MyException {
        DockerClient dockerClient = null;
        BoundListOperations listOperations = redisTemplate.boundListOps(HostIpUtil.getIp(uiDocker.getDockerIp()));
        listOperations.range(0,listOperations.size());

        try {
            dockerClient = DockerClientUtil.safetyConnection(uiDocker);
        } catch (Exception ex) {
            throw new MyException(ResultEnum.EDITUSER_ID_NULL);
        }
        return ResponseData.success("连接成功",dockerClient);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseData register(UiDocker uiDocker) throws MyException {
        String ip = HostIpUtil.getIp(uiDocker.getDockerIp());
        uiDocker.setDockerIp(ip);
        List<UiDocker> list =  baseMapper.selectByIpAndPortAndUserId(uiDocker);
        if (list.size() > 0) {
            return ResponseData.fail("已录入此信息");
        }
        baseMapper.insert(uiDocker);
        UiUser uiUser = new UiUser();
        uiUser.setId(uiDocker.getUserId());
        uiUser.setDockerId(uiDocker.getId());
        uiUserMapper.updateById(uiUser);
        return ResponseData.success("保存成功");
    }

    @Override
    public UiDocker getDockerByUserId(String userId) {
        UiDocker uiDocker = baseMapper.getDockerByUserId(userId);
        return uiDocker;
    }

    @Override
    public DockerExec getClient(String userId) {
        DockerExec dockerClient = clientBeans.get(userId);
        if (null == dockerClient) {
            UiDocker uiDocker = getDockerByUserId(userId);
            dockerClient = DockerClientUtil.safetyConnection(uiDocker);
            clientBeans.addClient(userId,dockerClient);
        }
        return dockerClient;
    }

}
