package com.issamdrmas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.issamdrmas.model.Todo;

public interface ITodoService {
 List<Todo> getTodosByUSer(String user);
 Optional<Todo> getTodoById(long id);
 void updateTodo(Todo todo);
 void addTodo(String name, String desc, Date targetDate, boolean isDone);
 void deleteTodo(long id);
 void savaTodo(Todo todo);
}
