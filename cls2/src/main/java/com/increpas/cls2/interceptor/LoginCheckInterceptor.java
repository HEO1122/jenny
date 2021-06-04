package com.increpas.cls2.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.*;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 할일
		// 세션에 로그인 정보가 있는지 꺼낸다.
		System.out.println("############### 인터셉터 작동 ####################");
		String sid = (String) request.getSession().getAttribute("SID");
		if(sid == null) {
			// 로그인이 안된 경우
			// 로그인페이지로 리다이렉트 시킨다.
			response.sendRedirect("/cls2/member/login.cls");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
