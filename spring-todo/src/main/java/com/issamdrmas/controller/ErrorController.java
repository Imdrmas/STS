package com.issamdrmas.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
@Controller("error")
public class ErrorController {
	public ModelAndView handleException(HttpServletRequest request, Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception.getLocalizedMessage());
		modelAndView.addObject("url", request.getRequestURI());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
