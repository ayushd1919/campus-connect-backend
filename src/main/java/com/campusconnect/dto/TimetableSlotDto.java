package com.campusconnect.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class TimetableSlotDto {
    private Long subjectId;
    private Long facultyId;
    private Long roomId;
    private Long departmentId;
    private Integer year;
    private String division;
    private String batch;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
