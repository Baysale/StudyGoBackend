package com.StudyGo.service;

import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.FlashCardCategory;
import com.StudyGo.model.User;
import com.StudyGo.repository.FlashCardCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlashCardCategoryServiceImpl implements FlashCardCategoryService{

    @Autowired
    private FlashCardCategoryRepository flashCardCategoryRepository;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<FlashCardCategory> findAll() {
        return flashCardCategoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FlashCardCategory loadFlashCardCategoryById(Long id) {
        return flashCardCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FlashCardCategory not found with id " + id));
    }

    @Override
    @Transactional
    public FlashCardCategory addFlashCardCategoryToUser(Long userId, RequestNameDTO request) {
        User user = userService.loadUserById(userId);

        FlashCardCategory flashCardCategory = new FlashCardCategory();
        flashCardCategory.setName(request.getName());
        flashCardCategory.setUser(user);

        FlashCardCategory savedFlashCardCategory = saveFlashCardCategory(flashCardCategory);

        user.getFlashCardCategories().add(savedFlashCardCategory);
        userService.saveUser(user);

        return savedFlashCardCategory;
    }

    @Override
    @Transactional
    public FlashCardCategory saveFlashCardCategory(FlashCardCategory flashCardCategory) {
        return flashCardCategoryRepository.save(flashCardCategory);
    }

    @Override
    @Transactional
    public FlashCardCategory updateFlashCardCategory(Long id, RequestNameDTO updatedFlashCardCategory) {
        FlashCardCategory flashCardCategory = flashCardCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FlashCardCategory not found with id " + id));

        flashCardCategory.setName(updatedFlashCardCategory.getName());

        return flashCardCategoryRepository.save(flashCardCategory);
    }

    @Override
    @Transactional
    public void deleteFlashCardCategory(Long id) {
        FlashCardCategory flashCardCategory = loadFlashCardCategoryById(id);
        flashCardCategoryRepository.delete(flashCardCategory);
    }

}
