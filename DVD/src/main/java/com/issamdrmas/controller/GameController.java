package com.issamdrmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.impl.GameImpl;
import com.issamdrmas.model.Game;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	private GameImpl gameImpl;
	
	@GetMapping("/games")
	public List<Game> getGames(){
		return gameImpl.getAll();
	}


	

}
