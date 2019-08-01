package com.issamdrmas.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.issamdrmas.security.JwtTokenUtil;

import javassist.expr.NewArray;

public class AuthenticationTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Value("${jwt.header}")
	private String tokenHeader;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
      String authToke = request.getHeader(this.tokenHeader); 
      if (authToke!=null && authToke.length()>7) {
    	  authToke = authToke.substring(7);
	}
      String username = jwtTokenUtil.getUsernameFormToken(authToke);
      if (username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		Boolean isValid = jwtTokenUtil.validateToken(authToke, userDetails);
		if (isValid) {
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
		}
	}
      filterChain.doFilter(request, response);
		
	}

}
