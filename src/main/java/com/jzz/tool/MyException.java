package com.jzz.tool;

import lombok.Getter;

/**
 * @author:jzz
 * @date:2020/12/28
 */
@Getter
public class MyException extends RuntimeException{

    private Integer code;
    private String message;

    public MyException (ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

}
