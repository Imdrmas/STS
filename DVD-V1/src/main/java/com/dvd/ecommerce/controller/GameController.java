package com.dvd.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.ecommerce.model.Game;
import com.dvd.ecommerce.service.GameService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/games")
public class GameController {
	private GameService gameService;	
	
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}

	@GetMapping(value = {"/games", "/"})
	public @NotNull Iterable<Game> getGamess(){
		return gameService.getAllGames();
	}
	@GetMapping("/games/{id}")
	public Optional<Game> getGameById(@PathVariable("id") Long gameId) {
	  Optional<Game> games = gameService.findById(gameId);
	  return games;
	}
	@PostMapping("/games/create")
	public Game createGame(@Valid @RequestBody Game game) {
		return gameService.save(game);
	}
	@PutMapping("/games/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") Long gameId, Game game){
	Optional<Game> games = gameService.findById(gameId);
	if (games.isPresent()) {
		Game game2 = games.get();
		game2.setName(game.getName());
		game2.setDescription(game.getDescription());
		game2.setPrice(game.getPrice());
		game2.setPictureUrl(game.getPictureUrl());
 	return new ResponseEntity<Game>(gameService.save(game2), HttpStatus.OK);
	}
	return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/games/{id}")
	public ResponseEntity<String> deleteGame(@PathVariable("id") Long gameId) {
		gameService.deleteById(gameId);
		return new ResponseEntity<String>("Game deleted", HttpStatus.OK);
	}


}
