package com.issamdrmas.controller;

import java.util.List;

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

import com.issamdrmas.model.Category;
import com.issamdrmas.services.ICategoryService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories(){
		return iCategoryService.getAll();
	}
	@GetMapping("/categories/{id}")
	public Category getMovieById(@PathVariable("id") long id) {
		return iCategoryService.getById(id);
	}
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		return iCategoryService.deleteById(id);
	}
    @PostMapping("/categories")
    public Category createMovie(@Valid @RequestBody Category movie) {
    	return iCategoryService.add(movie);
    }

}
