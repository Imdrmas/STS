package com.issamdrmas.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.MovieRepositpry;
import com.issamdrmas.model.Movie;


@RestController
@CrossOrigin(origins = "*")
public class MovieController {
	
	@Autowired
	MovieRepositpry movieRepositpry;
	

	public MovieController(MovieRepositpry movieRepositpry) {
		super();
		this.movieRepositpry = movieRepositpry;
	}
	
	@GetMapping("/findAllMovies")
	public List<Movie> findMovies() {
		List<Movie> list = movieRepositpry.findAll();
		list = list.stream().sorted(Comparator.comparing(Movie::get_id).reversed())
			     .collect(Collectors.toList());
		return list;
	}
	@GetMapping("/movie/details={_id}")
	public List<Movie> getMovieDetails(@PathVariable("_id") String _id) {
		return movieRepositpry.findBy_id(_id);
	}

	  @RequestMapping(value = "/movie/title", method = RequestMethod.GET)
	    public Movie getMovieByTilte() {
	     return movieRepositpry.findByTitleQuery("Alien");
	    }
	  
	  @RequestMapping(value = "/movie/years", method = RequestMethod.GET)
	    public List<Movie> getMovieByYear() {
	     return movieRepositpry.findByYear(1979);
	    }
	  
	  @RequestMapping(value = "/movie/id", method = RequestMethod.GET)
	    public Movie getMovieById() {
	     return movieRepositpry.findBy_idQuery("movie:2");
	    }
	  
	  @RequestMapping(value = "/movie/directoryId", method = RequestMethod.GET)
	    public List<Movie> getMovieBydirectoryId() {
	     return movieRepositpry.findDirectorBy_id("artist:4");
	    }

	  @RequestMapping(value = "/movie/search", method = RequestMethod.GET)
	    public List<Movie> getMovieByTitle() {
	     return movieRepositpry.findByTitle("Re");
	    }
	  @RequestMapping(value = "/movie/between/year", method = RequestMethod.GET)
	    public List<Movie> getMovieByBetweenYeare() {
	     List<Movie> movies = movieRepositpry.findMovieBetweenQuery(2000, 2005);
	     movies = movies.stream().sorted(Comparator.comparing(Movie::getYear))
	    		 .collect(Collectors.toList());
	     return movies;
	    }
	  @RequestMapping(value = "/movie/actor/id=23", method = RequestMethod.GET)
	    public List<Movie> findActorsBy_idAndTitle() {
	     return movieRepositpry.findActorsBy_id("artist:23");
	    }
	
}
