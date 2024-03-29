package com.jzz.tool;

import lombok.Getter;

/**
 * @author:jzz
 * @date:2020/12/28
 */
@Getter
public enum ResultEnum {
    HOST_IP_ERROR(100,"ip或域名解析错误"),
    REGISTER_USER_NULL(101,"用户信息为空，请检查填写信息"),
    REGISTER_USERNAME_NULL(102,"用户名为空，请检查填写信息"),
    REGISTER_PASSWORD_NULL(103,"用户密码为空，请检查填写信息"),
    EDITUSER_NOTFOUND(104,"用户不存在"),
    EDITUSER_ID_NULL(105,"编辑时，用户id为空"),
    CONNECT_DOCKER_TIMEOUT(106,"docker连接超时，请检查连接信息"),
    IP_PORT_NULL(107,"ip或端口为空，请检查"),
    SERVICE_ERROR(108,"服务异常，请稍后再试"),
    UPLOAD_FTP_FAILD(109,"上传文件到ftp失败"),
    FILE_NULL(110,"未选择文件"),
    BUILD_TAG_FAILED(111,"构建tag失败"),
    BUILD_TAG_EXIST(112,"新构建的tag已存在"),
    REMOVE_IMAGE_FAILED(113,"删除镜像失败"),
    NOT_FOUND_IMAGE(114,"未找到该镜像"),
    NOT_FOUND_INFO(114,"未找到连接信息"),
    FTP_FAILED(115,"连接ftp服务器失败，请检查网络以及相关配置")
    ;




    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
