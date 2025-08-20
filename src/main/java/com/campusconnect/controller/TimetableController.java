package com.campusconnect.controller;

import com.campusconnect.dto.TimetableSlotDto;
import com.campusconnect.entity.TimetableSlot;
import com.campusconnect.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/my-timetable")
    public ResponseEntity<List<TimetableSlot>> getMyTimetable(Principal principal) {
        String studentEmail = principal.getName();
        List<TimetableSlot> timetable = timetableService.getStudentTimetable(studentEmail);
        return ResponseEntity.ok(timetable);
    }
}
