package com.dvd.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.model.User;
import com.dvd.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dvd")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	@Secured("ROLE_USER")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/users/username/{username}")
	@Secured("ROLE_USER")
	public Optional<User> getUserByUsername(@PathVariable("username") String username) {
	  Optional<User> users = userRepository.findByUsername(username);
	  return users;
	}

	@PutMapping("/users/update/{id}")
	@Secured("ROLE_USER")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, User user){
	Optional<User> users = userRepository.findById(userId);
	if (users.isPresent()) {
		User _user = users.get();
	    _user.setUsername(user.getUsername());
	   // _user.setAddress(user.getAddress());
	    _user.setEmail(user.getEmail());
	    _user.setPassword(user.getPassword());
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long userId) {
		userRepository.deleteById(userId);
		return new ResponseEntity<String>("User deleted", HttpStatus.OK);
	}
	
} 