package com.jzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:jzz
 * @date:2020/12/29
 */
@Data
public class UiDocker implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String dockerIp;
    private Integer dockerPort;
    private String dockerName;
    private String dockerPwd;
    private String versionApi;
    private String registerUrl;
    private String registerEmail;
    private String certPath;

    @TableField(exist = false)
    private String userId;

}
