package com.example.auction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.auction.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	//인터셉터 등록
	private String[] excludePaths = {"/", "/login", "/join", "/logout"};
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor())
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns(excludePaths);
	}
	
}
