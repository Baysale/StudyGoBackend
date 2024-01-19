package com.StudyGo.service;

import com.StudyGo.model.User;
import com.StudyGo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User loadUserById(Long userId) throws NoSuchElementException {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException(userId + " does not exist"));
    }
}
