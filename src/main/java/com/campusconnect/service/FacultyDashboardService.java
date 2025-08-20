package com.campusconnect.service;

import com.campusconnect.dto.FacultyDashboardDto;
import com.campusconnect.entity.TimetableSlot;
import com.campusconnect.entity.User;
import com.campusconnect.repository.TimetableSlotRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class FacultyDashboardService {

    @Autowired
    private TimetableSlotRepository timetableSlotRepository;

    @Autowired
    private UserRepository userRepository;

    public FacultyDashboardDto getDashboardData(String facultyEmail) {
        User faculty = userRepository.findByEmail(facultyEmail)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        List<TimetableSlot> todaySchedule = timetableSlotRepository.findByFacultyAndDayOfWeek(faculty,today);

        FacultyDashboardDto dto = new FacultyDashboardDto();
        dto.setClassesTodayCount(todaySchedule.size());
        dto.setTodaySchedule(todaySchedule);

        dto.setTotalStudents(40);
        dto.setDocumentUploaded(5);
        dto.setActiveAnnouncements(10);

        return dto;
    }
}
