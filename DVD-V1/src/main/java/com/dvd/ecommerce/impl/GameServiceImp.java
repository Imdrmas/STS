package com.dvd.ecommerce.impl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.exception.ResourceNotFoundException;
import com.dvd.ecommerce.model.Game;
import com.dvd.ecommerce.repository.GameRepository;
import com.dvd.ecommerce.service.GameService;


@Service
@Transactional
public class GameServiceImp implements GameService{
	
	private GameRepository gameRepository;

	public GameServiceImp(GameRepository gameRepository) {
		super();
		this.gameRepository = gameRepository;
	}

	@Override
	public @NotNull Iterable<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Game getGame(@Min(value = 1, message = "Invalid game ID.") long id) {
		return gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game not found"));
	}

	@Override
	public Game save(Game game) {
		return gameRepository.save(game);
	}


}
