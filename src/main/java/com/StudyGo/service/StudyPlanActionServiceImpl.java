package com.StudyGo.service;

import com.StudyGo.dto.StudyPlanActionDTO;
import com.StudyGo.model.StudyPlanAction;
import com.StudyGo.model.User;
import com.StudyGo.repository.StudyPlanActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudyPlanActionServiceImpl implements StudyPlanActionService{

    @Autowired
    private StudyPlanActionRepository studyPlanActionRepository;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<StudyPlanAction> findAll() {
        return studyPlanActionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public StudyPlanAction loadStudyPlanActionById(Long id) {
        return studyPlanActionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudyPlanAction not found with id " + id));
    }

    @Override
    @Transactional
    public StudyPlanAction addStudyPlanActionToUser(Long userId, StudyPlanActionDTO studyPlanActionDTO) {
        User user = userService.loadUserById(userId);

        StudyPlanAction studyPlanAction = new StudyPlanAction();
        studyPlanAction.setName(studyPlanActionDTO.getName());
        studyPlanAction.setFromDate(studyPlanActionDTO.getFromDate());
        studyPlanAction.setToDate(studyPlanActionDTO.getToDate());
        studyPlanAction.setUser(user);

        StudyPlanAction savedStudyPlanAction = saveStudyPlanAction(studyPlanAction);

        user.getStudyPlanActions().add(savedStudyPlanAction);
        userService.saveUser(user);

        return savedStudyPlanAction;
    }

    @Override
    @Transactional
    public StudyPlanAction saveStudyPlanAction(StudyPlanAction studyPlanAction) {
        return studyPlanActionRepository.save(studyPlanAction);
    }

    @Override
    @Transactional
    public StudyPlanAction updateStudyPlanAction(Long id, StudyPlanActionDTO updatedStudyPlanAction) {
        StudyPlanAction studyPlanAction = studyPlanActionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudyPlanAction not found with id " + id));

        if(updatedStudyPlanAction.getName() != null || !updatedStudyPlanAction.getName().isEmpty()) {
            studyPlanAction.setName(updatedStudyPlanAction.getName());
        }
        if(updatedStudyPlanAction.getFromDate() != null) {
            studyPlanAction.setFromDate(updatedStudyPlanAction.getFromDate());
        }
        if(updatedStudyPlanAction.getToDate() != null) {
            studyPlanAction.setToDate(updatedStudyPlanAction.getToDate());
        }

        return studyPlanActionRepository.save(studyPlanAction);
    }

    @Override
    @Transactional
    public void deleteStudyPlanAction(Long id) {
        StudyPlanAction studyPlanAction = studyPlanActionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudyPlanAction not found with id " + id));

        studyPlanActionRepository.delete(studyPlanAction);
    }
}
