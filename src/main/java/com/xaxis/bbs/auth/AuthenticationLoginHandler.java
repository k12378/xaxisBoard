package com.xaxis.bbs.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationLoginHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	public AuthenticationLoginHandler(UserService userService){
		this.userService = userService;
	}
	
	/**
	 * onAuthenticationFailure
	 * 로그인 실패시 실행되는 이벤트 핸들러
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest req,
			HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.debug("로그인 실패");
		
		String userId = auth.getAuthentication().getPrincipal().toString();
		String userPw = auth.getAuthentication().getCredentials().toString();
		
		int errorCode = 0;
		
		if( !userService.isEqualsPassword(userPw) )
			errorCode = 2;		
				
		if( !userService.isUser(userId) )
			errorCode = 1;
		
		
		res.sendRedirect(req.getContextPath() + "/login/?errorCode="+ errorCode);
	}
	
	/**
	 * onAuthenticationSuccess
	 * 로그인 성공시 실행되는 이벤트 핸들러
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,
			HttpServletResponse res, Authentication auth) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		log.debug("로그인 성공");
		// ó�� �� ���� ����
		res.sendRedirect(req.getContextPath() + "/helloworld/hello/");
	}
}