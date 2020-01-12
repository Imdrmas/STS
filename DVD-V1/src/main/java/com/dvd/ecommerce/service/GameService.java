package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Game;


@Validated
public interface GameService {
	
	Game getGame(@Min(value = 1L, message = "Invalid game ID.") long id);
	
	Game save(Game game);
	
	void deleteById(Long productId);
	
	Optional<Game> findById(Long gameId);

	@NotNull
	List<Game> getAllGames();
	

}
