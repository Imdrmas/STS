package com.issamdrmas.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issamdrmas.model.Category;
@Service
public interface ICategoryService {
	public Category add(Category category);
	public List<Category> getAll();
	public ResponseEntity<Category> update(Long id, Category  category);
	public ResponseEntity<String> deleteById(Long id);
	public List<Category> getUsername(String username);
	public ResponseEntity<String>deleteAll();
	public Category getById(Long id);

}
