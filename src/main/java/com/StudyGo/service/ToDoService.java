package com.StudyGo.service;

import com.StudyGo.dto.ToDoListDTO;
import com.StudyGo.model.ToDo;

public interface ToDoService {

    public ToDo createToDoAndAddToToDoList(Long toDoListId, ToDoListDTO requestBody);
    public ToDo updateToDo(Long id, String name, Boolean done);
    public void deleteToDo(Long id);
}
