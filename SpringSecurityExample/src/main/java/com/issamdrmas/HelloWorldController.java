package com.issamdrmas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloWorldController {
 
 @RequestMapping(value="/user/home",method=RequestMethod.GET)
 public String helloUser() {
	 return "home";
 }
 @RequestMapping(value="/admin/admin",method=RequestMethod.GET)
 public String hello() {
	 return "admin";
 }
 @RequestMapping(value="/")
	public String home() {
		return "redirect:/user/home";
	}
	@RequestMapping(value="/404")
	public String accessDneied() {
		return "404";
	}
	@RequestMapping(value="/login")
	public String login() {
		return "login";
 }

}