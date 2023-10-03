package com.example.auction.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.auction.interceptor.LoginCheckInterceptor;

public class WebConfig implements WebMvcConfigurer {
    private final String[] excludePaths = {"/", "/member/join", "/member/login", "/member/logout", "/css/**", "/*.ico", "/error"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
    }
}
