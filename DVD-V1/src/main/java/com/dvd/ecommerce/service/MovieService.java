package com.dvd.ecommerce.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Movie;

@Validated
public interface MovieService {
	@NotNull Iterable<Movie> getAllMovies();
	Movie getMovie(@Min(value = 1L, message = "Invalid movie ID.") long id);
	Movie save(Movie movie);

}
