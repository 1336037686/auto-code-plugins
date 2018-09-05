package com.lgxtvt.config;

import com.lgxtvt.modules.app.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 *
 * @author LGX_TvT
 * @date 2018-09-05 21:35
 */
@Configuration
public class WebMvcConfig{

    /**
     * 添加页面
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("autoCodeLoginView");
                registry.addViewController("/").setViewName("autoCodeLoginView");
                registry.addViewController("/login.html").setViewName("autoCodeLoginView");
                registry.addViewController("/login").setViewName("autoCodeLoginView");
                registry.addViewController("/autoCodeIndexView").setViewName("autoCodeIndexView");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 注册过滤器
     */
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter(){
        FilterRegistrationBean<LoginFilter> loginFilter = new FilterRegistrationBean<>();
        loginFilter.setFilter(new LoginFilter());
        loginFilter.setUrlPatterns(Arrays.asList("/*"));
        return loginFilter;
    }

}
