package com.campusconnect.service;

import com.campusconnect.dto.TimetableSlotDto;
import com.campusconnect.entity.*;
import com.campusconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableSlotRepository timetableSlotRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<TimetableSlot> getStudentTimetable(String studentEmail) {
        User student = userRepository.findByEmail(studentEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found with email: " + studentEmail));

        return timetableSlotRepository.findStudentTimetable(
                student.getDepartment(),
                student.getYear(),
                student.getDivision(),
                student.getBatch()
        );
    }

    public TimetableSlot createTimetableSlot(TimetableSlotDto slotDto) {

        Subject subject = subjectRepository.findById(slotDto.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject not found"));
        User faculty = userRepository.findById(slotDto.getFacultyId()).orElseThrow(() -> new RuntimeException("Faculty not found"));
        Room room = roomRepository.findById(slotDto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Department department = departmentRepository.findById(slotDto.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));

        TimetableSlot newSlot = new TimetableSlot();
        newSlot.setSubject(subject);
        newSlot.setFaculty(faculty);
        newSlot.setRoom(room);
        newSlot.setDepartment(department);
        newSlot.setYear(slotDto.getYear());
        newSlot.setDivision(slotDto.getDivision());
        newSlot.setBatch(slotDto.getBatch());
        newSlot.setDayOfWeek(slotDto.getDayOfWeek());
        newSlot.setStartTime(slotDto.getStartTime());
        newSlot.setEndTime(slotDto.getEndTime());
        return timetableSlotRepository.save(newSlot);
    }
}
