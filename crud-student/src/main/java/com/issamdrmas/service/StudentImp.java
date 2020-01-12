package com.issamdrmas.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.issamdrmas.dao.StudentDao;
import com.issamdrmas.model.Student;

@Component
public class StudentImp implements StudentService {
	
	private StudentDao studentDao;

	@Override
	public Student save(Student student) {
		return studentDao.save(student);
	}

	@Override
	public void getById(Long id) {
		studentDao.findById(id);
		
	}

	@Override
	public List<Student> getAll() {
		return (List<Student>) studentDao.findAll();
	}

	@Override
	public void delete(Long id) {
		studentDao.deleteById(id);
		
	}

	@Override
	public Student update(Student student) {
		return studentDao.save(student);
	}

}
