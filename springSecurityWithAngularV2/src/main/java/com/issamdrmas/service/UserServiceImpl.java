package com.issamdrmas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.model.User;
import com.issamdrmas.security.UserRepository;
import com.issamdrmas.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		String passwordString = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(passwordString);
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmailIgnoreCase(email);
	}

}
