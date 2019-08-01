package com.issamdrmas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.domin.Response;
import com.issamdrmas.model.User;
import com.issamdrmas.service.UserService;

import javassist.expr.NewArray;

@RestController
public class PreLoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser = userService.create(user);
		if (dbUser!=null) {
			return new ResponseEntity<Response>(new Response("User is saved successfullt"), HttpStatus.OK);
		}
		return null;
	}

}
