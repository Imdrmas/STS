package com.dvd.ecommerce.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public Game getGame(@Min(value = 1, message = "Invalid game ID.") long id) {
		return gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game not found"));
	}

	@Override
	public Game save(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public void deleteById(Long productId) {
		gameRepository.deleteById(productId);
		
	}

	@Override
	public Optional<Game> findById(Long gameId) {
		return gameRepository.findById(gameId);
	}

	@Override
	public @NotNull List<Game> getAllGames() {
		List<Game> list = gameRepository.findAll();
		List<Game> sortedList = list.stream().sorted(Comparator.comparing(Game::getId).reversed())
				.collect(Collectors.toList());
		return sortedList;
				
	}


}
