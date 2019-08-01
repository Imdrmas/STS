package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findByName(String name);

}
