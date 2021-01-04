package com.jzz.controller;

import com.jzz.data.ResponseData;
import com.jzz.pojo.UiDocker;
import com.jzz.service.UiDockerService;
import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;
import com.jzz.util.FileUtil;
import com.jzz.util.OSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author:jzz
 * @date:2020/12/10
 */

@RestController
@RequestMapping("docker")
public class UiDockerController {

    @Autowired
    private UiDockerService uiDockerService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("register")
    public ResponseData registerDocker (@RequestBody UiDocker uiDocker) throws Exception {
        if (!ObjectUtils.isEmpty(uiDocker)) {
            if (StringUtils.isEmpty(uiDocker.getDockerIp()) || StringUtils.isEmpty(uiDocker.getDockerPort())) {
                throw new MyException(ResultEnum.IP_PORT_NULL);
            }
        } else {
            throw new MyException(ResultEnum.IP_PORT_NULL);
        }
        ResponseData responseData = uiDockerService.register(uiDocker);
        return responseData;
    }

    @PostMapping("connect")
    public ResponseData connectDocker (@RequestBody UiDocker uiDocker) throws MyException {
        ResponseData responseData = uiDockerService.connect(uiDocker);
        return responseData;
    }

    @PostMapping("upload/{dockerIp}")
    public String uploadCretFile (@PathVariable("dockerIp") String dockerIp , @RequestParam("file") MultipartFile file) throws Exception {
        if (ObjectUtils.isEmpty(file)) {
            throw new MyException(ResultEnum.FILE_NULL);
        }
        String path = "";
        if (OSUtil.isLinux()) {
            path = FileUtil.uploadFtp(dockerIp, file.getInputStream(), file.getOriginalFilename());
        } else {
            path = FileUtil.uploadLocal(dockerIp, file.getInputStream(), file.getOriginalFilename());
        }
        return path;
    }



}
