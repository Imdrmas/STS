package com.dvd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.dvd.ecommerce.model.Game;

public interface GameRepository extends CrudRepository<Game, Long> {

}
