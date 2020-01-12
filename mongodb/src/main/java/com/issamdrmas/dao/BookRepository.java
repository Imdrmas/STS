package com.issamdrmas.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>  {

}
