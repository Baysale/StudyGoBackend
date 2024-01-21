package com.StudyGo.controller;

import com.StudyGo.dto.FlashCardDTO;
import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.FlashCard;
import com.StudyGo.model.FlashCardCategory;
import com.StudyGo.service.FlashCardCategoryService;
import com.StudyGo.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashCardCategory")
@CrossOrigin
public class FlashCardCategoryController {

    @Autowired
    private FlashCardCategoryService flashCardCategoryService;
    @Autowired
    private FlashCardService flashCardService;

    @GetMapping
    public ResponseEntity<List<FlashCardCategory>> getAllFlashCardCategories() {
        List<FlashCardCategory> flashCardCategories = flashCardCategoryService.findAll();
        return ResponseEntity.ok(flashCardCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashCardCategory> getFlashCardCategoryById(@PathVariable Long id) {
        FlashCardCategory flashCardCategory = flashCardCategoryService.loadFlashCardCategoryById(id);
        return ResponseEntity.ok(flashCardCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashCardCategory> updateFlashCardCategory(@PathVariable Long id,
                                                                 @RequestBody RequestNameDTO request) {
        FlashCardCategory updateFlashCardCategory = flashCardCategoryService.updateFlashCardCategory(id, request);
        return ResponseEntity.ok(updateFlashCardCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlashCardCategory(@PathVariable Long id) {
        flashCardCategoryService.deleteFlashCardCategory(id);
        return ResponseEntity.ok().body("FlashCardCategory successfully deleted");
    }

    @PostMapping("/{id}/flashCard")
    public ResponseEntity<FlashCard> createFlashCard(@PathVariable Long id, @RequestBody FlashCardDTO requestBody) {
        FlashCard createdFlashCard = flashCardService.addFlashCardToCategory(id, requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlashCard);
    }
}
