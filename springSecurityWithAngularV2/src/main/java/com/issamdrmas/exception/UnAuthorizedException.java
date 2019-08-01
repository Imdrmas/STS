package com.issamdrmas.exception;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnAuthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static MessageSourceAccessor mAccessor = SpringSecurityMessageSource.getAccessor();
	
	public UnAuthorizedException() {
		super(mAccessor.getMessage("AbstractAcess", "Acess is denited"));
	}
	
	public UnAuthorizedException(String message) {
		super(message);
	}
}
