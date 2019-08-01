package com.dvd.ecommerce.impl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.exception.ResourceNotFoundException;
import com.dvd.ecommerce.model.Movie;
import com.dvd.ecommerce.repository.MovieRepository;
import com.dvd.ecommerce.service.MovieService;

@Service
@Transactional
public class MovieServiceImp implements MovieService{
	
	private MovieRepository movieRepository;
	
	public MovieServiceImp(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public @NotNull Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie getMovie(@Min(value = 1, message = "Invalid movie ID.") long id) {
		return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
	}

}
