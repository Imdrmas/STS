package com.dvd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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


	@GetMapping(value = {"", "/"})
	public @NotNull Iterable<Game> getGamess(){
		return gameService.getAllGames();
	}

}
