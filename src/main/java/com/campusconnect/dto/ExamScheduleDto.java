package com.campusconnect.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ExamScheduleDto {
    private Long examId;
    private Long subjectId;
    private LocalDate examDate;
    private LocalTime startTime;
}
