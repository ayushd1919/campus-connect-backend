package com.campusconnect.dto;

import com.campusconnect.entity.Subject.SubjectType;
import lombok.Data;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;
    private Long departmentId;
    private SubjectType type;
    private Integer semester;
    private Long electiveTrackId;
    private boolean hasIaexam;
    private boolean hasPracticalExam;
    private boolean hasVivaExam;
    private boolean hasSemesterExam;
}
