package com.campusconnect.dto;

import com.campusconnect.entity.TimetableSlot;
import lombok.Data;

import java.util.List;

@Data
public class FacultyDashboardDto {
    private long classesTodayCount;
    private long totalStudents;
    private long documentUploaded;
    private long activeAnnouncements;
    private List<TimetableSlot> todaySchedule;
}
