package com.campusconnect.controller;

import com.campusconnect.dto.*;
import com.campusconnect.entity.Room;
import com.campusconnect.entity.Subject;
import com.campusconnect.entity.TimetableSlot;
import com.campusconnect.entity.User;
import com.campusconnect.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private TimetableService timetableService;

    @PostMapping("/timetable")
    public ResponseEntity<TimetableSlot> addTimetableSlot(@RequestBody TimetableSlotDto slotDto) {
        TimetableSlot newSlot = timetableService.createTimetableSlot(slotDto);
        return ResponseEntity.ok(newSlot);
    }

    @GetMapping("/stats")
    public ResponseEntity<DashboardStatsDto> getDashboardStats() {
        return ResponseEntity.ok(dashboardService.getDashboardStats());
    }

    // --- ROOM MANAGEMENT ---
    @PostMapping("/rooms")
    public ResponseEntity<Room> addRoom(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.createRoom(roomDto));
    }
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    //--- SUBJECT MANAGEMENT ENDPOINTS ---
    @PostMapping("/subjects")
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectDto subjectDto) {
        Subject newSubject = subjectService.createSubject(subjectDto);
        return ResponseEntity.ok(newSubject);
    }
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Integer semester) {

        List<Subject> subjects;

        if(departmentId != null && semester != null) {
            subjects = subjectService.getSubjectsByDepartmentAndSemester(departmentId, semester);
        } else if (departmentId != null) {
            subjects = subjectService.getSubjectByDepartment(departmentId);
        } else if (semester != null) {
            subjects = subjectService.getSubjectsBySemester(semester);
        } else {
            subjects = subjectService.getAllSubjects();
        }
        return ResponseEntity.ok(subjects);
    }
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        return ResponseEntity.ok(subjectService.updateSubject(id,subjectDto));
    }
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    // --- FACULTY MANAGEMENT ---

    @PostMapping("/faculty")
    public ResponseEntity<User> addFaculty(@RequestBody FacultyRegistrationDto facultyDto) {
        User newFaculty = userService.registerFaculty(facultyDto);
        return ResponseEntity.ok(newFaculty);
    }
    @GetMapping("/faculty")
    public ResponseEntity<List<User>> getAllFaculty() {
        return ResponseEntity.ok(userService.getAllFaculty());
    }
    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
