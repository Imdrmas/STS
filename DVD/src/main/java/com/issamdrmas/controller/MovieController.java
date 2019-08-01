package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.impl.MovieImpl;
import com.issamdrmas.model.Movie;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	private MovieImpl movieImpl;
	
	
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return movieImpl.getAllMovies();
	}

	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable("id") long id) {
		return movieImpl.getById(id);
	}
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		return movieImpl.deleteById(id);
	}
    @PostMapping("/movies")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
    	return movieImpl.add(movie);
    }
	

}
