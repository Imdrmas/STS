package com.dvd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dvd.ecommerce.model.Music;
import com.dvd.ecommerce.service.MusicService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/musics")
public class MusicController {
	
	private MusicService musicService;
	
	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}


	@GetMapping(value = {"", "/"})
	public @NotNull Iterable<Music> getMusics(){
		return musicService.getAllMusics();
	}

}
