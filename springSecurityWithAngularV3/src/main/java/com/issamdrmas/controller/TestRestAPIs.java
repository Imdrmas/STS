package com.issamdrmas.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestRestAPIs {
	
	@GetMapping(value = "/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User content";
	}
	
	@GetMapping(value = "/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagentAccess() {
		return ">>> Project Mangement Beard";
	}

	@GetMapping(value = "/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin content";
	}
	
	  @RequestMapping("/")
	    public String home(){
	        return "Hello World!";
	    }
}
