package com.StudyGo.controller;

import com.StudyGo.dto.StudyPlanActionDTO;
import com.StudyGo.dto.ToDoListDTO;
import com.StudyGo.model.StudyPlanAction;
import com.StudyGo.model.ToDoList;
import com.StudyGo.model.User;
import com.StudyGo.repository.ToDoListRepository;
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

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "New User added";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers()  {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.loadUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/toDoList")
    public ResponseEntity<String> addToDoList(@PathVariable Long userId, @RequestBody ToDoListDTO request){
        toDoListService.addToDoListToUser(userId, request);
        return new ResponseEntity<>("ToDoList created successfully!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/studyPlanAction")
    public ResponseEntity<String> addStudyPlanAction(@PathVariable Long userId, @RequestBody StudyPlanActionDTO request){
        studyPlanActionService.addStudyPlanActionToUser(userId, request);
        return new ResponseEntity<>("StudyPlanAction created successfully!", HttpStatus.OK);
    }
}
