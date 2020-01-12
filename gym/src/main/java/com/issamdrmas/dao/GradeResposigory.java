package com.issamdrmas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Grade;

public interface GradeResposigory extends MongoRepository<Grade, String> {

}
