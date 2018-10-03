package com.lgxtvt.modules.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 * @author LGX_TvT
 * @date 2018-09-05 17:35
 */

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private Environment env;

    /**
     * 获取登陆用户名
     * @return
     */
    @RequestMapping("/getLoginUser")
    public String getLoginUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
