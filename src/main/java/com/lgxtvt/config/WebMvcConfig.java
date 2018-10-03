package com.lgxtvt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author LGX_TvT
 * @date 2018-09-05 21:35
 */
@Configuration
public class WebMvcConfig{

    private final String PREFIX = "pages/";

    /**
     * 添加页面
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login.html").setViewName(PREFIX + "autoCodeLoginView");
                registry.addViewController("/").setViewName(PREFIX + "autoCodeLoginView");
                registry.addViewController("/index").setViewName(PREFIX + "autoCodeIndexView");
            }
        };
        return webMvcConfigurer;
    }

//    /**
//     * 注册过滤器
//     */
//    @Bean
//    public FilterRegistrationBean<LoginFilter> loginFilter(){
//        FilterRegistrationBean<LoginFilter> loginFilter = new FilterRegistrationBean<>();
//        loginFilter.setFilter(new LoginFilter());
//        loginFilter.setUrlPatterns(Arrays.asList("/*"));
//        return loginFilter;
//    }
}
