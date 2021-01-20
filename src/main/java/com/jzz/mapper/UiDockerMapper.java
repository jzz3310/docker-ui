package com.jzz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzz.pojo.UiDocker;
import com.jzz.pojo.UiUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:jzz
 * @date:2020/12/28
 */
@Mapper
public interface UiDockerMapper extends BaseMapper<UiDocker> {

    List<UiDocker> selectByIpAndPortAndUserId(UiDocker uiDocker);

    UiDocker getDockerByUserId(String userId);
}
