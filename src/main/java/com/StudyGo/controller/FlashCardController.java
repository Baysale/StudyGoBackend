package com.StudyGo.controller;

import com.StudyGo.dto.FlashCardDTO;
import com.StudyGo.dto.RequestNameDTO;
import com.StudyGo.model.FlashCard;
import com.StudyGo.model.ToDo;
import com.StudyGo.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashCard")
@CrossOrigin
public class FlashCardController {

    @Autowired
    private FlashCardService flashCardService;

    @GetMapping
    public ResponseEntity<List<FlashCard>> getAllFlashCards() {
        List<FlashCard> flashCardCategories = flashCardService.findAll();
        return ResponseEntity.ok(flashCardCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashCard> getFlashCardById(@PathVariable Long id) {
        FlashCard flashCard = flashCardService.loadFlashCardById(id);
        return ResponseEntity.ok(flashCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashCard> updateFlashCard(@PathVariable Long id, @RequestBody FlashCardDTO request) {
        FlashCard updateFlashCard = flashCardService.updateFlashCard(id, request);
        return ResponseEntity.ok(updateFlashCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlashCard(@PathVariable Long id) {
        flashCardService.deleteFlashCard(id);
        return ResponseEntity.ok().body("FlashCard successfully deleted");
    }
}
