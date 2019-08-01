package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.issamdrmas.dao.CategoryRepository;
import com.issamdrmas.model.Category;
import com.issamdrmas.services.ICategoryService;
@Repository
public class CategoryImpl implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category add(@RequestBody Category category) {
		Category category2 = categoryRepository.save(new Category(category.getId(), category.getNameCat(), category.getCreateAt(), 
				category.getMusics(), category.getMovies(), category.getGames()));
		return category2;
		
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		 categoryRepository.findAll().forEach(categories::add);
		 return categories;
	}

	@Override
	public ResponseEntity<Category> update(Long id, Category  c) {
		Optional<Category> categorysOptional = categoryRepository.findById(id);
		if (categorysOptional != null) {
			Category categorys = categorysOptional.get();
			categorys.setId(c.getId());
			categorys.setNameCat(c.getNameCat());
			categorys.setCreateAt(c.getCreateAt());
			categorys.setMovies(c.getMovies());
			categorys.setMusics(c.getMusics());
			categorys.setGames(c.getGames());
			categoryRepository.save(categorys);
			return new ResponseEntity<Category>(categoryRepository.save(categorys), HttpStatus.OK);
		}else {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		categoryRepository.deleteById(id);
		return new ResponseEntity<String>("Category has been deleted!", HttpStatus.OK);
	}


	@Override
	public ResponseEntity<String>deleteAll() {
		categoryRepository.deleteAll();
		return new ResponseEntity<String>("All Category have been deleted!", HttpStatus.OK);
		
	}

	@Override
	public List<Category> getUsername(String username) {
		//List<Category> categories = categoryRepository.findByName(username);
		return null;
	}

	@Override
	public Category getById(Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if (categoryOptional.isPresent()) {
			Category c = categoryOptional.get();
			return c;
		}
		return null;
	}

}
