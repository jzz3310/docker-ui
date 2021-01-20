package com.jzz.controller;

import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.SearchItem;
import com.jzz.bean.MyTest;
import com.jzz.data.ResponseData;
import com.jzz.service.UiDockerService;
import com.jzz.tool.DockerExec;
import com.jzz.tool.MessageEnum;
import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:jzz
 * @date:2021/1/5
 */
@RestController
@RequestMapping("/exec/image")
public class DockerExecController {

    @Autowired
    private UiDockerService uiDockerService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MyTest myTest;


    @GetMapping("list/{userId}")
    public ResponseData getImageList (@PathVariable("userId") String userId) {
        DockerExec connect = uiDockerService.getClient(userId);
        try {
            List<Image> imageList = connect.listImagesCmd().exec();
            return ResponseData.success(imageList);
        } catch (Exception exception) {
            return ResponseData.fail(ResultEnum.CONNECT_DOCKER_TIMEOUT.getMessage());
        }
    }

    @GetMapping("search/{userId}")
    public ResponseData searchImages (@PathVariable("userId") String userId,
                                          @Param("keywords") String keywords) {
        DockerExec connect = uiDockerService.getClient(userId);
        try {
            List<SearchItem> exec = connect.searchImagesCmd(keywords).exec();
            return ResponseData.success(exec);
        } catch (Exception exception) {
            return ResponseData.fail(ResultEnum.CONNECT_DOCKER_TIMEOUT.getMessage());
        }
    }

    @GetMapping("build/{userId}")
    public ResponseData buildTag (@PathVariable("userId") String userId,
                                  @Param("imageName") String imageName,
                                  @Param("image") String image,
                                  @Param("tag") String tag) throws MyException {
        DockerExec connect = uiDockerService.getClient(userId);
        if (connect.isExistTag(image+":"+tag)) {
            return ResponseData.fail(ResultEnum.BUILD_TAG_EXIST.getMessage());
        }
        try {
            connect.tagImageCmd(imageName, image, tag).exec();
            return ResponseData.success(MessageEnum.BUILD_TAG_SUCCESS.getMessage());
        } catch (Exception e) {
            return ResponseData.fail(ResultEnum.BUILD_TAG_FAILED.getMessage());
        }
    }

    @GetMapping("remove/{userId}")
    public ResponseData removeImage (@PathVariable("userId") String userId,
                                   @Param("imageName") String imageName) {
        DockerExec connect = uiDockerService.getClient(userId);
        try {
            connect.removeImageCmd(imageName).exec();
            return ResponseData.success(MessageEnum.REMOVE_IMAGE_SUCCESS.getMessage());
        } catch (NotFoundException exception) {
            return ResponseData.fail(ResultEnum.NOT_FOUND_IMAGE.getMessage());
        } catch (Exception exception) {
            return ResponseData.fail(ResultEnum.REMOVE_IMAGE_FAILED.getMessage());
        }
    }

    @GetMapping("search/local/{userId}")
    public ResponseData searchImage () {
        return null;
    }


    @GetMapping("/test")
    public MyTest test () {
        BoundValueOperations key = redisTemplate.boundValueOps("key");
        System.out.println(key.get());
        return myTest;
    }


}
