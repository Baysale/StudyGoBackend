package com.StudyGo.service;

import com.StudyGo.model.ToDoList;

public interface ToDoListService {
    public void saveToDoList(ToDoList toDoList);
    public ToDoList updateToDoListName(Long id, String newName);
    public void deleteToDoList(Long id);
    public ToDoList loadToDoListById(Long toDoListId);
}
