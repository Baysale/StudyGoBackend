package com.StudyGo.service;

import com.StudyGo.dto.FlashCardDTO;
import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.FlashCard;
import com.StudyGo.model.FlashCardCategory;
import com.StudyGo.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlashCardServiceImpl implements FlashCardService{
    @Autowired
    private FlashCardRepository flashCardRepository;
    @Autowired
    private FlashCardCategoryService flashCardCategoryService;

    @Override
    @Transactional(readOnly = true)
    public List<FlashCard> findAll() {
        return flashCardRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FlashCard loadFlashCardById(Long id) {
        return flashCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FlashCard not found with id " + id));
    }

    @Override
    @Transactional
    public FlashCard addFlashCardToCategory(Long categoryId, FlashCardDTO request) {
        FlashCardCategory category = flashCardCategoryService.loadFlashCardCategoryById(categoryId);

        FlashCard flashCard = new FlashCard();
        flashCard.setQuestion(request.getQuestion());
        flashCard.setAnswer(request.getAnswer());
        flashCard.setFlashCardCategory(category);

        FlashCard savedFlashCard = saveFlashCard(flashCard);

        category.getFlashCards().add(savedFlashCard);
        flashCardCategoryService.saveFlashCardCategory(category);

        return savedFlashCard;
    }

    @Override
    @Transactional
    public FlashCard saveFlashCard(FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    @Override
    @Transactional
    public FlashCard updateFlashCard(Long id, FlashCardDTO updatedFlashCard) {
        FlashCard flashCard = flashCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FlashCard not found with id " + id));

        flashCard.setQuestion(updatedFlashCard.getQuestion());
        flashCard.setAnswer(updatedFlashCard.getAnswer());

        return flashCardRepository.save(flashCard);
    }

    @Override
    @Transactional
    public void deleteFlashCard(Long id) {
        FlashCard flashCard = loadFlashCardById(id);
        flashCardRepository.delete(flashCard);
    }
}
