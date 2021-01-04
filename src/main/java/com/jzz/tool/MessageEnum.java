package com.jzz.tool;

import lombok.Getter;

/**
 * @author:jzz
 * @date:2020/12/28
 */
@Getter
public enum MessageEnum {
    REGISTER_SUCCESS(101,"注册成功"),
    ;



    private Integer code;
    private String message;
    MessageEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
