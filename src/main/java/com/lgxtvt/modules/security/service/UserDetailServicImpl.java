package com.lgxtvt.modules.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring Security登陆角色过滤
 * 默认角色：admin 123456
 * @author LGX_TvT
 * @date 2018-10-03 11:06
 */
@Service
public class UserDetailServicImpl implements UserDetailsService {

    @Autowired
    private Environment env;

    @Autowired
    private HttpServletRequest request;

    /**
     * 登陆角色过滤
     * 可以通过username获取数据库角色进行登录判断
     * 使用BCrypt加密对象
     * 使用bcpe.matches判断密码是否相同
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        String defaultUsername = env.getProperty("auto-code-defaultUserName");
        String defaultPassword = env.getProperty("auto-code-defaultPassword");
        String password = request.getParameter("password");

        if(defaultUsername.equals(username) && bcpe.matches(password,bcpe.encode(defaultPassword))){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_User"));
            return new User(username,bcpe.encode(password),authorities);
        }else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}
