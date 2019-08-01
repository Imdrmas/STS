package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.issamdrmas.model.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT p FROM User p WHERE p.username LIKE :c")
List<User> findByUsernameContains(@Param("c") String usrname);
}
