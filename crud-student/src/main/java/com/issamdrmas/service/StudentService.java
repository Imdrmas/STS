package com.issamdrmas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.issamdrmas.model.Student;

@Service
public interface StudentService {
	Student save(Student student);
	void getById(Long id);
	List<Student> getAll();
	void delete(Long id);
	Student update(Student student);

}
