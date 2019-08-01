package com.issamdrmas.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.entities.Role;
import com.issamdrmas.entities.User;
import com.issamdrmas.message.request.JwtResponse;
import com.issamdrmas.message.request.ResponseMessage;
import com.issamdrmas.model.LoginForm;
import com.issamdrmas.model.RoleName;
import com.issamdrmas.model.SignUpForm;
import com.issamdrmas.repository.RoleRepository;
import com.issamdrmas.repository.UserRepository;
import com.issamdrmas.security.jwt.JwtProvider;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping(value = "/signin")
	public ResponseEntity<?> authenticationUSer(@Valid @RequestBody LoginForm loginRequest, BindingResult result){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		 if (result.hasErrors()) {
		        return new ResponseEntity<>(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.BAD_REQUEST);
		    }
		
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> authenticationUSer(@Valid @RequestBody SignUpForm signUpRequest){
		if (userRepository.existsByUsername(signUpRequest.getPassword())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already in use!"), HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
		}
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(), 
				passwordEncoder.encode(signUpRequest.getPassword()));
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<Role>();
		
		strRoles.forEach(role -> {
			switch(role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
				      .orElseThrow(() -> new RuntimeException("Fail! -> Case: User Role not find. "));
				roles.add(adminRole);
				break;
				
		   case "pm":
			   Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
			   .orElseThrow(() -> new RuntimeException("Fail! -> Case: PM Role not find. "));
				roles.add(pmRole);
				break;
			
		   default:
			   Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
			   .orElseThrow(() -> new RuntimeException("Fail! -> Case: User Role not find. "));
				roles.add(userRole);
				break;
			}
		});
		user.setRoles(roles);
		userRepository.save(user);
		
		return new ResponseEntity<>(new ResponseMessage("User Registered Successfully!"), HttpStatus.OK);
	}
	

}
