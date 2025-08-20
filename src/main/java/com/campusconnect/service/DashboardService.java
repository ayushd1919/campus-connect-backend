package com.campusconnect.service;

import com.campusconnect.dto.DashboardStatsDto;
import com.campusconnect.entity.Role;
import com.campusconnect.repository.RoomRepository;
import com.campusconnect.repository.SubjectRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private RoomRepository roomRepository;

    public DashboardStatsDto getDashboardStats() {
        long studentCount = userRepository.findByRole(Role.STUDENT).size();
        long facultyCount = userRepository.findByRole(Role.FACULTY).size();
        long roomCount = roomRepository.count();
        long subjectCount = subjectRepository.count();

        return new DashboardStatsDto(studentCount,facultyCount,roomCount,subjectCount);
    }


}
