package com.StudyGo.service;

import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.ToDo;
import com.StudyGo.model.ToDoList;
import com.StudyGo.repository.ToDoListRepository;
import com.StudyGo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    @Transactional
    public ToDo createToDoAndAddToToDoList(Long toDoListId, RequestNameDTO requestBody) {
        ToDoList toDoList = toDoListRepository.findById(toDoListId)
                .orElseThrow(() -> new RuntimeException("ToDoList not found with id " + toDoListId));
        ToDo toDo = new ToDo();
        toDo.setName(requestBody.getName());
        toDo.setToDoList(toDoList);
        toDoList.getToDos().add(toDo); // Optional, depending on how you manage the relationship

        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo updateToDo(Long id, String name, Boolean done) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id " + id));

        if (name != null && !name.isEmpty()) {
            toDo.setName(name);
        }
        if (done != null) {
            toDo.setDone(done);
        }

        return toDoRepository.save(toDo);
    }

    @Override
    @Transactional
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id " + id));
        toDoRepository.delete(toDo);
    }
}
