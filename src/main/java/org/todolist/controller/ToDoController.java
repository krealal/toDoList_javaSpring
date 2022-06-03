package org.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todolist.model.ToDo;
import org.todolist.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {


    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/list")
    public ResponseEntity<List<ToDo>> getAllToDo(@RequestParam(required = false)String toDo){
        try {
            List<ToDo> toDos = new ArrayList<ToDo>();

            if (toDo == null)
                toDos.addAll(toDoRepository.findAll());
            else
                toDos.addAll(toDoRepository.findByToDoContaining(toDo));

            if (toDos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(toDos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<ToDo> createToDo(@RequestParam ToDo toDo){
    try {
        ToDo _toDo = toDoRepository.save(new ToDo(toDo.getToDo(), toDo.getDescription(), false));
        return new ResponseEntity<>(_toDo, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>deleteToDo(@PathVariable("id") String id){
        try {
            toDoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
