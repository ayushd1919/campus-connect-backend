package com.campusconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "elective_tracks")
public class ElectiveTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;
}
