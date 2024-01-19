package com.StudyGo.controller;

import com.StudyGo.model.ToDo;
import com.StudyGo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toDo")
@CrossOrigin
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) Boolean done) {
        ToDo updatedToDo = toDoService.updateToDo(id, name, done);
        return ResponseEntity.ok(updatedToDo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return ResponseEntity.ok().body("ToDo successfully deleted");
    }
}
