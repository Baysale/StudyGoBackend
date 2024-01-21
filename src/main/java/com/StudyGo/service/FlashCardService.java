package com.StudyGo.service;

import com.StudyGo.dto.FlashCardDTO;
import com.StudyGo.model.FlashCard;

import java.util.List;

public interface FlashCardService {
    public List<FlashCard> findAll();
    public FlashCard loadFlashCardById(Long id);
    public FlashCard addFlashCardToCategory(Long categoryId, FlashCardDTO request);
    public FlashCard saveFlashCard(FlashCard flashCard);
    public FlashCard updateFlashCard(Long id, FlashCardDTO updatedFlashCard);
    public void deleteFlashCard(Long id);
}
