package com.issamdrmas.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.issamdrmas.model.Vol;

@Repository
public interface VolRepisotory extends JpaRepository<Vol, Long> {
    @Query("SELECT p FROM Vol p WHERE p.piloteCode LIKE :c")
	public List<Vol> getPiloteCode(@Param("c")String code);
}

