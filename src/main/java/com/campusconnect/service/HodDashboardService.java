package com.campusconnect.service;

import com.campusconnect.dto.HodDashboardDto;
import com.campusconnect.entity.TimetableSlot;
import com.campusconnect.entity.User;
import com.campusconnect.repository.TimetableSlotRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class HodDashboardService {

    @Autowired
    private TimetableSlotRepository timetableSlotRepository;

    @Autowired
    private UserRepository userRepository;

    public HodDashboardDto getDashboardData(String hodEmail) {
        User hod = userRepository.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));

        DayOfWeek today = LocalDate.now().getDayOfWeek();
        List<TimetableSlot> todaySchedule = timetableSlotRepository.findByFacultyAndDayOfWeek(hod,today);

        HodDashboardDto dto = new HodDashboardDto();
        dto.setClassesTodayCount(todaySchedule.size());
        dto.setTodaySchedule(todaySchedule);

        dto.setActiveAnnouncements(12);
        dto.setTotalStudents(55);
        dto.setDocumentsUploaded(10);

        return dto;
    }
}
