package com.StudyGo.service;

import com.StudyGo.model.ToDoList;
import com.StudyGo.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListServiceImpl implements ToDoListService{
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public ToDoList saveToDoList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }
}
