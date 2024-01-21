package com.StudyGo.service;

import com.StudyGo.dto.StudyPlanActionDTO;
import com.StudyGo.model.StudyPlanAction;

import java.util.List;

public interface StudyPlanActionService {

    public List<StudyPlanAction> findAll();
    public StudyPlanAction loadStudyPlanActionById(Long id);
    public StudyPlanAction addStudyPlanActionToUser(Long userId, StudyPlanActionDTO studyPlanActionDTO);
    public StudyPlanAction saveStudyPlanAction(StudyPlanAction studyPlanAction);
    public StudyPlanAction updateStudyPlanAction(Long id, StudyPlanActionDTO updatedStudyPlanAction);
    public void deleteStudyPlanAction(Long id);
}
