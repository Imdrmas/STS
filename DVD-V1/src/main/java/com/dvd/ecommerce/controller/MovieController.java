package com.dvd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = {"", "/"})
	public @NotNull Iterable<Movie> getMovies(){
		return movieService.getAllMovies();
	}

}
