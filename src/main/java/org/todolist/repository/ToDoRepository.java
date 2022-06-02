package org.todolist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.todolist.model.ToDo;

import java.util.List;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
    List<ToDo> findByToDoContaining(String toDo);




}
