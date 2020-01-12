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

import com.dvd.ecommerce.model.Movie;
import com.dvd.ecommerce.service.MovieService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping(value = {"/movies", "/"})
	public @NotNull Iterable<Movie> getMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("/movies/{id}")
	public Optional<Movie> getMovieById(@PathVariable("id") Long movieId) {
	  Optional<Movie> movies = movieService.findById(movieId);
	  return movies;
	}
	@PostMapping("/movies/create")
	public Movie createMovie(@Valid @RequestBody Movie movie) {
		return movieService.save(movie);
	}
	@PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long movieId, Movie movie){
	Optional<Movie> movies = movieService.findById(movieId);
	if (movies.isPresent()) {
		Movie movie2 = movies.get();
		movie2.setName(movie.getName());
		movie2.setDescription(movie.getDescription());
		movie2.setPrice(movie.getPrice());
		movie2.setPictureUrl(movie.getPictureUrl());
		return new ResponseEntity<Movie>(movieService.save(movie2), HttpStatus.OK);
	}
	return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<String> deleteMoviee(@PathVariable("id") Long movieId) {
		movieService.deleteById(movieId);
		return new ResponseEntity<String>("Movie deleted", HttpStatus.OK);
	}


}
