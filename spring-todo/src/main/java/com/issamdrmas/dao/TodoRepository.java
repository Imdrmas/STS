package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.issamdrmas.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
      List<Todo> findByName(String name);
}
