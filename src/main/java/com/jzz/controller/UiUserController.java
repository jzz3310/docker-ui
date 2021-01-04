package com.jzz.controller;

import com.jzz.data.ResponseData;
import com.jzz.pojo.UiUser;
import com.jzz.service.UiUserService;
import com.jzz.tool.MyException;
import com.jzz.tool.ResultEnum;
import com.jzz.util.TimeUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author:jzz
 * @date:2020/12/16
 */
@RestController
@RequestMapping("user")
public class UiUserController {

    @Autowired
    private UiUserService uiUserService;

    @PostMapping("save/{type}")
    public ResponseData resgister (@RequestBody UiUser uiUser, @PathVariable("type") String type) throws MyException {
        if (null == uiUser) {
            throw new MyException(ResultEnum.REGISTER_USER_NULL);
        } else {
            if (StringUtils.isNullOrEmpty(uiUser.getName())) {
                throw new MyException(ResultEnum.REGISTER_USERNAME_NULL);
            }
            if (StringUtils.isNullOrEmpty(uiUser.getPassword())) {
                throw new MyException(ResultEnum.REGISTER_PASSWORD_NULL);
            }
        }

        if ("edit".equals(type)) {
            if (StringUtils.isNullOrEmpty(uiUser.getId())) {
                throw new MyException(ResultEnum.EDITUSER_ID_NULL);
            }
            UiUser user = uiUserService.getById(uiUser.getId());
            if (user == null) {
                throw new MyException(ResultEnum.EDITUSER_NOTFOUND);
            }
        } else if ("save".equals(type)) {
            uiUser.setId(UUID.randomUUID().toString().replace("-", ""));
            uiUser.setCentime(new Date());
        }
        boolean save = uiUserService.edit(uiUser);
        return ResponseData.result(save,"编辑用户",uiUser);
    }



}
