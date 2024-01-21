package com.StudyGo.controller;

import com.StudyGo.dto.StudyPlanActionDTO;
import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.User;
import com.StudyGo.service.FlashCardCategoryService;
import com.StudyGo.service.StudyPlanActionService;
import com.StudyGo.service.ToDoListService;
import com.StudyGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ToDoListService toDoListService;
    @Autowired
    private StudyPlanActionService studyPlanActionService;
    @Autowired
    private FlashCardCategoryService flashCardCategoryService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "New User added";
    }

    @GetMapping()
    public List<User> getAllUsers()  {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.loadUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/toDoList")
    public ResponseEntity<String> addToDoList(@PathVariable Long userId, @RequestBody RequestNameDTO request){
        toDoListService.addToDoListToUser(userId, request);
        return new ResponseEntity<>("ToDoList created successfully!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/studyPlanAction")
    public ResponseEntity<String> addStudyPlanAction(@PathVariable Long userId, @RequestBody StudyPlanActionDTO request){
        studyPlanActionService.addStudyPlanActionToUser(userId, request);
        return new ResponseEntity<>("StudyPlanAction created successfully!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/flashCardCategory")
    public ResponseEntity<String> addFlashCardCategory(@PathVariable Long userId, @RequestBody RequestNameDTO request){
        flashCardCategoryService.addFlashCardCategoryToUser(userId, request);
        return new ResponseEntity<>("FlashCardCategory created successfully!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/toDoList/{month}")
    public ResponseEntity<String> mapStudyPlanActionsToToDoList(@PathVariable Long userId, @PathVariable int month){
        toDoListService.mapStudyPlanActionsToToDoList(userId, month);
        return new ResponseEntity<>("ToDoList created successfully from Studyplan!", HttpStatus.OK);
    }
}
