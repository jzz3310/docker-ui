package com.jzz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serializable;

/**
 * @author:jzz
 * @date:2020/12/29
 */
@Data
public class UiUserDocker implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String userId;
    private Long dockerId;
    private int status;

}
