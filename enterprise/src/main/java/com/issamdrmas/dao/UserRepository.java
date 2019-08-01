package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issamdrmas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
