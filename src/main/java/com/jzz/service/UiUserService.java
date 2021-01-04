package com.jzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzz.pojo.UiUser;

/**
 * @author:jzz
 * @date:2020/12/16
 */
public interface UiUserService extends IService<UiUser> {
    boolean edit(UiUser uiUser);
}
