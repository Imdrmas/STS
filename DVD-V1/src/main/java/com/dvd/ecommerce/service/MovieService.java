package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Movie;

@Validated
public interface MovieService {
	@NotNull List<Movie> getAllMovies();
	
	Movie getMovie(@Min(value = 1L, message = "Invalid movie ID.") long id);
	
	Movie save(Movie movie);
	
	void deleteById(Long movieId);
	
	Optional<Movie> findById(Long movieId);

}
