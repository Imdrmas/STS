package com.issamdrmas.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.issamdrmas.model.User;

@Service
public interface UserService {
    public User createUser(User user);
    public Collection<User> getAllUsers();
    public Optional<User> findUserById(int id);
    public void deleteUserById(int id);
    public void updateUser(User user);
    public void deleteAlUsers();
}
