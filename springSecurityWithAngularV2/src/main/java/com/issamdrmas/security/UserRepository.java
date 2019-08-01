package com.issamdrmas.security;

import org.springframework.data.repository.CrudRepository;

import com.issamdrmas.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailIgnoreCase(String username);

}
