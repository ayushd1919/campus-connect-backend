package com.campusconnect.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_elective_selections")
@Data
public class StudentElectiveSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "dloc_track_id", nullable = true)
    private ElectiveTrack dlocTrack;

    @ManyToOne
    @JoinColumn(name = "iloc_track_id",nullable = true)
    private ElectiveTrack ilocTrack;

}
