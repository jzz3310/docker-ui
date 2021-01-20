package com.jzz.tool;

import lombok.Getter;

/**
 * @author:jzz
 * @date:2020/12/28
 */
@Getter
public enum MessageEnum {
    REGISTER_SUCCESS(1000,"注册成功"),
    BUILD_TAG_SUCCESS(1001,"构建tag成功"),
    REMOVE_IMAGE_SUCCESS(1002,"删除镜像成功")


    ;



    private Integer code;
    private String message;
    MessageEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
