package com.issamdrmas.services;

import java.util.List;

import com.issamdrmas.model.User;
import com.issamdrmas.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
