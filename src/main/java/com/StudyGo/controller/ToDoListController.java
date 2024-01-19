package com.StudyGo.controller;

import com.StudyGo.dto.ToDoListDTO;
import com.StudyGo.model.ToDoList;
import com.StudyGo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toDoList")
@CrossOrigin
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateToDoList(@PathVariable Long id, @RequestBody ToDoListDTO request) {
        ToDoList updatedToDoList = toDoListService.updateToDoListName(id, request.getName());
        return ResponseEntity.ok(updatedToDoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoList(@PathVariable Long id) {
        toDoListService.deleteToDoList(id);
        return ResponseEntity.ok().build();
    }
}
