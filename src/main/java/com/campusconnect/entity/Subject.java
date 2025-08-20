package com.campusconnect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.print.PrinterIOException;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {

    public enum SubjectType{
        CORE, DLOC, ILOC
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String subjectCode;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubjectType type = SubjectType.CORE;

    @Column(nullable = false)
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "elective_track_id", nullable = true)
    private ElectiveTrack electiveTrack;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean hasPracticalExam = false;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hasIaExam = true;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hasVivaExam = false;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hasSemesterExam = false;
}
