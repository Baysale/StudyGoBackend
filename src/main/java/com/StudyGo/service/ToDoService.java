package com.StudyGo.service;

import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.ToDo;

public interface ToDoService {

    public ToDo createToDoAndAddToToDoList(Long toDoListId, RequestNameDTO requestBody);
    public ToDo updateToDo(Long id, String name, Boolean done);
    public void deleteToDo(Long id);
}
