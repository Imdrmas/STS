package com.dvd.ecommerce.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Music;

@Validated
public interface MusicService {
	@NotNull Iterable<Music> getAllMusics();
	//Music getMusic(@Min(value = 1L, message = "Invalid movie ID.") long id);
	Music save(Music music);

}
