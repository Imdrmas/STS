package com.issamdrmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.impl.MusicImpl;
import com.issamdrmas.model.Music;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MusicController {
	
	@Autowired
	private MusicImpl musicImpl;
	
	@GetMapping("/musics")
	public List<Music> getMmusics(){
		return musicImpl.getAll();
	}


	

}
