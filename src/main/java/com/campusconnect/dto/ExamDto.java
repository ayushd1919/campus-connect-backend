package com.campusconnect.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamDto {
    private String name;
    private Integer semester;
    private LocalDate startDate;
    private LocalDate endDate;
}
