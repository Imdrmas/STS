package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.issamdrmas.dao.GameRepository;
import com.issamdrmas.model.Game;
import com.issamdrmas.services.IGameService;
@Repository
public class GameImpl implements IGameService {
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public Game add(Game game) {
		Game game2 = gameRepository.save(new Game(game.getId(), game.getName(), game.getDescription(), game.getPrice(), game.getCreateAt(),
				 game.getCategory()));
		return game2;
	}

	@Override
	public List<Game> getAll() {
		List<Game> games = new ArrayList<Game>();
		gameRepository.findAll().forEach(games::add);
		return games;
	}

	@Override
	public ResponseEntity<Game> update(Long id, Game game) {
		Optional<Game> gOptional = gameRepository.findById(id);
		if (gOptional.isPresent()) {
			Game g = gOptional.get();
			g.setId(game.getId());
			g.setName(game.getName());
			g.setDescription(game.getDescription());
			g.setPrice(game.getPrice());
			g.setCreateAt(game.getCreateAt());
			g.setCategory(game.getCategory());
			gameRepository.save(g);
			return new ResponseEntity<Game>(gameRepository.save(g), HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		gameRepository.deleteById(id);
		return new ResponseEntity<String>("Customer has been deleted!", HttpStatus.OK);
	}

	@Override
	public List<Game> getUsername(String username) {
		List<Game> games = gameRepository.findByName(username);
		return games;
	}

	@Override
	public ResponseEntity<String> deleteAll() {
		gameRepository.deleteAll();
		return new ResponseEntity<String>("All customer have been deleted!", HttpStatus.OK);
	}

	@Override
	public Game getById(Long id) {
		Optional<Game> gOptional = gameRepository.findById(id);
		if (gOptional.isPresent()) {
			Game game = gOptional.get();
			return game;
		}
		return null;
	}

}
