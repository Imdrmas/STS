package com.issamdrmas.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.issamdrmas.controller.dao.UserDao;
import com.issamdrmas.model.User;

@Component
public class UserServiceImpl implements UserService{

    UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User createUser(User users) {
       return dao.save(users);
    }

    @Override
    public Collection<User> getAllUsers() {
        return dao.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return dao.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.save(user);
    }

    @Override
    public void deleteAlUsers() {
        dao.deleteAll();
    }
}
