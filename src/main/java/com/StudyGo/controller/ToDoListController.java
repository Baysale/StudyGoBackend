package com.StudyGo.controller;

import com.StudyGo.dto.ToDoListDTO;
import com.StudyGo.model.ToDo;
import com.StudyGo.model.ToDoList;
import com.StudyGo.service.ToDoListService;
import com.StudyGo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toDoList")
@CrossOrigin
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;
    @Autowired
    private ToDoService toDoService;

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateToDoList(@PathVariable Long id,
                                                   @RequestParam("name") String name) {
        ToDoList updatedToDoList = toDoListService.updateToDoListName(id, name);
        return ResponseEntity.ok(updatedToDoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoList(@PathVariable Long id) {
        toDoListService.deleteToDoList(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{toDoListId}/todo")
    public ResponseEntity<ToDo> createToDo(@PathVariable Long toDoListId,
                                           @RequestBody ToDoListDTO requestBody) {
        ToDo createdToDo = toDoService.createToDoAndAddToToDoList(toDoListId, requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdToDo);
    }
}
