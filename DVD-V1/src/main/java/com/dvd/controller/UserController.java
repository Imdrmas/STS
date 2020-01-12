package com.dvd.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.model.User;
import com.dvd.repository.UserRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dvd")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/username/{username}")
	public Optional<User> getUserByUsername(@PathVariable("username") String username) {
	  Optional<User> users = userRepository.findByUsername(username);
	  return users;
	}
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long userId) {
	  Optional<User> users = userRepository.findById(userId);
	  return users;
	}
	@PostMapping("/users/update")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, User user){
	Optional<User> users = userRepository.findById(userId);
	if (users.isPresent()) {
		User _user = users.get();
		_user.setName(user.getName());
	    _user.setUsername(user.getUsername());
	    _user.setEmail(user.getEmail());
	    _user.setNameOnCard(user.getNameOnCard());
	    _user.setCardNumber(user.getCardNumber());
	    _user.setExpMonth(user.getExpMonth());
	    _user.setCvv(user.getCvv());
	    _user.setExpYear(user.getExpYear());
	    _user.setAddress(user.getAddress());
	    _user.setCity(user.getCity());
	    _user.setZip(user.getZip());
	    _user.setState(user.getState());
	    _user.setPassword(user.getPassword());
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userRepository.deleteById(userId);
		return new ResponseEntity<String>("User deleted", HttpStatus.OK);
	}

	
} 