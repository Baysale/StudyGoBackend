package com.StudyGo.service;

import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.FlashCardCategory;

import java.util.List;

public interface FlashCardCategoryService {
    public List<FlashCardCategory> findAll();
    public FlashCardCategory loadFlashCardCategoryById(Long id);
    public FlashCardCategory addFlashCardCategoryToUser(Long userId, RequestNameDTO request);
    public FlashCardCategory saveFlashCardCategory(FlashCardCategory flashCardCategory);
    public FlashCardCategory updateFlashCardCategory(Long id, RequestNameDTO updatedFlashCardCategory);
    public void deleteFlashCardCategory(Long id);
}
