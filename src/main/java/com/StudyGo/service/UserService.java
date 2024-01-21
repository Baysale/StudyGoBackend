package com.StudyGo.service;

import com.StudyGo.model.User;
import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User loadUserById(Long userId);
    public User loadUserByUserName(String username);
    public boolean existsByUserName(String username);
}
