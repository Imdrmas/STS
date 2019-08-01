package com.issamdrmas.service;

import java.util.List;

import com.issamdrmas.model.User;

public interface UserService {

	User create(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
