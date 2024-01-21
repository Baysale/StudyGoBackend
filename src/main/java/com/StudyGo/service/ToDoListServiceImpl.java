package com.StudyGo.service;

import com.StudyGo.dto.ToDoListDTO;
import com.StudyGo.model.ToDoList;
import com.StudyGo.model.User;
import com.StudyGo.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
public class ToDoListServiceImpl implements ToDoListService{
    @Autowired
    private ToDoListRepository toDoListRepository;
    @Autowired
    private UserService userService;

    @Override
    public ToDoList loadToDoListById(Long toDoListId) throws NoSuchElementException {
        return toDoListRepository.findById(toDoListId).orElseThrow(() -> new NoSuchElementException(toDoListId + " does not exist"));
    }

    @Override
    @Transactional
    public ToDoList addToDoListToUser(Long userId, ToDoListDTO toDoListDTO) {
        User user = userService.loadUserById(userId);

        ToDoList toDoList = new ToDoList();
        toDoList.setName(toDoListDTO.getName());
        toDoList.setUser(user);

        ToDoList savedToDoList = saveToDoList(toDoList);

        user.getToDoLists().add(savedToDoList);
        userService.saveUser(user);

        return savedToDoList;
    }

    @Override
    public ToDoList saveToDoList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
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
