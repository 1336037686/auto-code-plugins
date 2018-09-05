package com.lgxtvt.modules.app.controller;

import com.lgxtvt.modules.app.entity.Message;
import com.lgxtvt.modules.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
     * 用户登陆
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public Message login(@RequestBody User user, HttpSession session){
        System.out.println(user);
        String userName = env.getProperty("auto-code-userName");
        String password = env.getProperty("auto-code-password");
        if (userName.equals(user.getUserName())  &&  password.equals(user.getPassword())){
            session.setAttribute("user",userName);
            return new Message("Login Success",true);
        }
        return new Message("Login Error",false);
    }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public Message logout(HttpSession session){
        session.invalidate();
        return new Message("logout Success",true);
    }

    /**
     * 获取登陆用户名
     * @param session
     * @return
     */
    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session){
        return (String) session.getAttribute("user");
    }

}
