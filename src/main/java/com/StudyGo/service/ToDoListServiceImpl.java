package com.StudyGo.service;

import com.StudyGo.model.ToDoList;
import com.StudyGo.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ToDoListServiceImpl implements ToDoListService{
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public void saveToDoList(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
    }

    @Override
    public ToDoList updateToDoListName(Long id, String newName) {
        return toDoListRepository.findById(id).map(toDoList -> {
            toDoList.setName(newName);
            return toDoListRepository.save(toDoList);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ToDoList not found"));
    }

    @Override
    public void deleteToDoList(Long id) {
        ToDoList toDoList = toDoListRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ToDoList not found"));
        toDoListRepository.delete(toDoList);
    }
}
