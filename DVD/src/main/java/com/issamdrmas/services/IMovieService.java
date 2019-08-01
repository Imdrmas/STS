package com.issamdrmas.services;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import com.issamdrmas.model.Movie;

public interface IMovieService {
	public Movie add(Movie movie);
	public List<Movie> getAllMovies();
	public ResponseEntity<Movie> update(Long id, Movie  movie);
	public ResponseEntity<String> deleteById(Long id);
	public List<Movie> getUsername(String username);
	public ResponseEntity<String>deleteAll();
	public Movie getById(Long id);
	public Movie getMovie(@Min(value = 1L, message = "Invalid product ID.") long id);

}
