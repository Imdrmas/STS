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

	@GetMapping(value = {"/musics", "/"})
	public @NotNull Iterable<Music> getMusics(){
		return musicService.getAllMusics();
	}
	@GetMapping("/musics/{id}")
	public Optional<Music> getMusicById(@PathVariable("id") Long musicId) {
	  Optional<Music> musics = musicService.findById(musicId);
	  return musics;
	}
	@PostMapping("/musics/create")
	public Music createMusic(@Valid @RequestBody Music music) {
		return musicService.save(music);
	}
	@PutMapping("/musics/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable("id") Long musicId, Music music){
	Optional<Music> musics = musicService.findById(musicId);
	if (musics.isPresent()) {
	    Music music2 = musics.get();
	    music2.setName(music.getName());
	    music2.setDescription(music.getDescription());
	    music2.setPrice(music.getPrice());
	    music2.setPictureUrl(music.getPictureUrl());
		return new ResponseEntity<Music>(musicService.save(music2), HttpStatus.OK);
	}
	return new ResponseEntity<Music>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/musics/{id}")
	public ResponseEntity<String> deleteMusic(@PathVariable("id") Long muiscId) {
		musicService.deleteById(muiscId);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}


}
