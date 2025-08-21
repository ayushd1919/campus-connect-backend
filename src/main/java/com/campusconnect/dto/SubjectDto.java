package com.campusconnect.dto;

import com.campusconnect.entity.Subject.SubjectType;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;
    private Long departmentId;
    private SubjectType type;
    private Integer semester;
    private Long electiveTrackId;
    private boolean hasIaExam;
    @JsonAlias("hasIaExam")
    public void setHasIaExam(boolean v) { this.hasIaExam = v; }
    private boolean hasPracticalExam;
    private boolean hasVivaExam;
    private boolean hasSemesterExam;
}
