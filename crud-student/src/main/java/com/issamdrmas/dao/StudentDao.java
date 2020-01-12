package com.issamdrmas.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Long> {


}
