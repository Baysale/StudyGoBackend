package com.StudyGo.service;

import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.ToDoList;

public interface ToDoListService {
    public ToDoList saveToDoList(ToDoList toDoList);
    public ToDoList addToDoListToUser(Long userId, RequestNameDTO requestNameDTO);
    public ToDoList updateToDoListName(Long id, String newName);
    public void deleteToDoList(Long id);
    public ToDoList loadToDoListById(Long toDoListId);
}
