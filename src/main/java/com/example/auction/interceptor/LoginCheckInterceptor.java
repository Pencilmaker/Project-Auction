package com.example.auction.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
			HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginMember") == null) {
			response.sendRedirect("/member/login");
			return false;
		}
		return true;
}
}
