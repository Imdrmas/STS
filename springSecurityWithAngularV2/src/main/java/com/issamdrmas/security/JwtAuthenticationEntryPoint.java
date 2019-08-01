package com.issamdrmas.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	      throws IOException, ServletException {
	    // 401
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
	  }

	  @ExceptionHandler (value = {AccessDeniedException.class})
	  public void commence(HttpServletRequest request, HttpServletResponse response,
	      AccessDeniedException accessDeniedException) throws IOException {
	    // 401
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization Failed : " + accessDeniedException.getMessage());
	  }

}
