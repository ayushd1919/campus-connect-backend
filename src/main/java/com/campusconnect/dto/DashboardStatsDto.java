package com.campusconnect.dto;

import lombok.Data;

@Data
public class DashboardStatsDto {
    private long totalStudents;
    private long totalRooms;
    private long totalFaculty;
    private long totalSubjects;

    public DashboardStatsDto(long totalStudents, long totalFaculty, long totalRooms, long totalSubjects) {
        this.totalStudents = totalStudents;
        this.totalFaculty = totalFaculty;
        this.totalRooms = totalRooms;
        this.totalSubjects = totalSubjects;
    }
}
