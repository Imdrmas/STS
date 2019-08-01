package com.dvd.ecommerce.impl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.model.Music;
import com.dvd.ecommerce.repository.MusicRepository;
import com.dvd.ecommerce.service.MusicService;

@Service
@Transactional
public class MusicServiceImp implements MusicService{
	
	private MusicRepository musicRepository;
	
	public MusicServiceImp(MusicRepository musicRepository) {
		super();
		this.musicRepository = musicRepository;
	}

	@Override
	public @NotNull Iterable<Music> getAllMusics() {
		return musicRepository.findAll();
	}


	@Override
	public Music save(Music music) {
		return musicRepository.save(music);
	}
	

	

}
