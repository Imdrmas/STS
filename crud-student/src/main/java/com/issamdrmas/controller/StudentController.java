package com.issamdrmas.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.StudentDao;
import com.issamdrmas.model.Student;
import com.issamdrmas.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	private StudentDao service;
	
	@RequestMapping("findAll")
	public Iterable<Student> findAll() {
		return service.findAll();
	}
	

	@PostMapping("save")
	public Student save(@RequestBody Student student) {
		return service.save(student);
	}
	

}
