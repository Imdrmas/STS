package com.issamdrmas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.issamdrmas.model.User;
import com.issamdrmas.service.UserService;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Qualifier("userService")
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user) {
       return userService.createUser(user);
    }

    @GetMapping("/user/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> getAll() {
        System.out.println("-------> : getAllUsers");
        logger.debug("Getting all users.");
        return userService.getAllUsers();
    }
    @GetMapping("/user/getUser/{id}")
    public Optional<User> getId(@PathVariable(value = "id") int id){
        logger.debug("Getting users with user id = {} .", id);
        return userService.findUserById(id);
    }
    @PutMapping("/admin/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable(value = "id") int id, @RequestBody User user) {
        logger.debug("update user with user id {}", id);
        user.setId(id);
        userService.updateUser(user);
        return "user record for user id = " +id+ " update.";
    }
    @DeleteMapping("/admin/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") int id) {
        logger.debug("Deleting user with user id = {}.", id);
        userService.deleteUserById(id);
        return "user record for user id "+ id + " deleted.";
    }
    @DeleteMapping(value = "/admin/delete/all")
    public String deleteAll() {
        logger.debug("Deleting all users.");
        userService.deleteAlUsers();
        return "All users records deleted.";
    }
}
