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
	public @NotNull List<Music> getAllMusics() {
		List<Music> list = musicRepository.findAll();
		List<Music> sortedList = list.stream()
				.sorted(Comparator.comparing(Music::getId)
				.reversed())
		.collect(Collectors.toList());
		return sortedList;
	}


	@Override
	public Music save(Music music) {
		return musicRepository.save(music);
	}

	@Override
	public Music getMusic(@Min(value = 1, message = "Invalid music ID.") long id) {
		return musicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("music not found"));
	}

	@Override
	public void deleteById(Long muiscId) {
		musicRepository.deleteById(muiscId);
		
	}

	@Override
	public Optional<Music> findById(Long musicId) {
		return musicRepository.findById(musicId);
	}
	

	

}
