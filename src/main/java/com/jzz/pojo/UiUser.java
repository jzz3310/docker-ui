package com.jzz.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:jzz
 * @date:2020/12/16
 */
@Data
@TableName("ui_user")
public class UiUser implements Serializable {

    private String id;
    private String name;
    private String password;
    @TableLogic
    private int status;
    private Date centime;
    private Date maritime;
    private Long dockerId;

}
