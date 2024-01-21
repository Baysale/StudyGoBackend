package com.StudyGo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudyPlanActionDTO {
    private String name;
    private LocalDate fromDate;
    private LocalDate toDate;
}
