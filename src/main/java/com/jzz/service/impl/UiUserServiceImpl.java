package com.jzz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzz.mapper.UiUserMapper;
import com.jzz.pojo.UiUser;
import com.jzz.service.UiUserService;
import com.jzz.tool.EncryptionByMD5;
import com.jzz.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author:jzz
 * @date:2020/12/16
 */
@Service
public class UiUserServiceImpl extends ServiceImpl<UiUserMapper,UiUser> implements UiUserService {

    @Override
    public boolean edit(UiUser uiUser) {
        uiUser.setMaritime(new Date());
        uiUser.setPassword(EncryptionByMD5.getMD5(uiUser.getPassword()));
        boolean result = this.saveOrUpdate(uiUser);
        return result;
    }
}
