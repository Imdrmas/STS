package com.issamdrmas.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.issamdrmas.model.Avion;

public interface AvionRepisotory extends JpaRepository<Avion, Long> {
	@Query("SELECT u.id FROM Avion u WHERE u.id LIKE CONCAT('%',:id,'%')")
	String findUsersWithPartOfName(String id);

}

