package com.StudyGo.controller;

import com.StudyGo.dto.StudyPlanActionDTO;
import com.StudyGo.model.StudyPlanAction;
import com.StudyGo.service.StudyPlanActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studyPlanAction")
@CrossOrigin
public class StudyPlanActionController {
    @Autowired
    private StudyPlanActionService studyPlanActionService;

    @GetMapping
    public ResponseEntity<List<StudyPlanAction>> getAllStudyPlanActions() {
        List<StudyPlanAction> actions = studyPlanActionService.findAll();
        return ResponseEntity.ok(actions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyPlanAction> getStudyPlanActionById(@PathVariable Long id) {
        StudyPlanAction action = studyPlanActionService.loadStudyPlanActionById(id);
        return ResponseEntity.ok(action);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyPlanAction> updateStudyPlanAction(@PathVariable Long id,
                                                                 @RequestBody StudyPlanActionDTO studyPlanActionDetails) {
        StudyPlanAction updatedAction = studyPlanActionService.updateStudyPlanAction(id, studyPlanActionDetails);
        return ResponseEntity.ok(updatedAction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudyPlanAction(@PathVariable Long id) {
        studyPlanActionService.deleteStudyPlanAction(id);
        return ResponseEntity.ok().body("StudyPlanAction successfully deleted");
    }
}
