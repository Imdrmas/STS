package com.dvd.ecommerce.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Game;


@Validated
public interface GameService {
	@NotNull Iterable<Game> getAllGames();
	Game getGame(@Min(value = 1L, message = "Invalid game ID.") long id);
	Game save(Game game);

}
