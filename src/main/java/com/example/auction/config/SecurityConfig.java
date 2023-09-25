package com.example.auction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		// Cross-site request forgery 보호기능 비활성화 (session 기능을 사용하지 않을꺼면 disable 사용)
		.csrf().disable()
		// iframe으로 접근이 안되도록 하는 설정을 비활성화
		.headers().frameOptions().disable()
		.and()
		// URL별 권한 접근 제어
		.authorizeRequests()
		// permitAll () : 설정한 리소스의 접근을 인증절차 없이 허용
		.antMatchers("/", "/member/join", "/member/login", "/member/logout", "/member/login-failed").permitAll()
		.antMatchers("/css/*", "/favicon.ico", "/error").permitAll()
		.anyRequest().authenticated()
		.and()
		// 폼 로그인 방식을 사용
		.formLogin()
		// username 파라미터의 기본값은 username이고 다른 이름으로 사용하면 이름을 지정해줘야 한다.
		.usernameParameter("member_id")
		// 사용자가 만든 로그인 페이지를 사용함
		// 설정하지 않으면 기본 URL이 "/login"이 된다.
		.loginPage("/member/login")
		// 로그인 인증 처리를 하는 URL
		.loginProcessingUrl("/member/login")
		// 인증에 성공 했을 때 이동할 URL
		.defaultSuccessUrl("/member/login-success")
		// 로그인 실패 시 이동할 URL
		.failureUrl("/member/login-failed");
		
		return http.build();
	}

}
