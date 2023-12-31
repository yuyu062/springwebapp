package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.dto.Ch08Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch08LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//log.info("실행");
		
		//요청처리 메소드가 @Login가 붙어있는지 확인
		HandlerMethod handlerMehtod = (HandlerMethod)handler;
		Login login = handlerMehtod.getMethodAnnotation(Login.class);
		
		//@Login이 붙어있다면 
		if(login != null) {
			HttpSession session = request.getSession();
			Ch08Member member = (Ch08Member)session.getAttribute("login");
			//로그인이 되어있다면
			if(member != null) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/ch08/content");
				return false;
			}
		}else{
			//@Login이 붙어 있지 않다면
			return true;
		}
	}
}
