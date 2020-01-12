package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Music;

@Validated
public interface MusicService {
	
	@NotNull List<Music> getAllMusics();
	
	Music getMusic(@Min(value = 1L, message = "Invalid music ID.") long id);
	
	Music save(Music music);
	
	void deleteById(Long muiscId);
	
	Optional<Music> findById(Long musicId);

}
