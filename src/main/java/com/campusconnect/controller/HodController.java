package com.campusconnect.controller;

import com.campusconnect.dto.ExamDto;
import com.campusconnect.dto.ExamScheduleDto;
import com.campusconnect.dto.HodDashboardDto;
import com.campusconnect.entity.Exam;
import com.campusconnect.entity.ExamSchedule;
import com.campusconnect.entity.Subject;
import com.campusconnect.repository.ExamScheduleRepository;
import com.campusconnect.service.ExamService;
import com.campusconnect.service.HodDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/hod")
public class HodController {

    @Autowired
    private HodDashboardService dashboardService;

    @Autowired
    private ExamService examService;
    @Autowired
    private ExamScheduleRepository examScheduleRepository;

    @GetMapping("/dashboard")
    public ResponseEntity<HodDashboardDto> getDashboardData(Principal principal) {
        return ResponseEntity.ok(dashboardService.getDashboardData(principal.getName()));
    }

    // --- EXAM MANAGEMENT ENDPOINTS ---

    @PostMapping("/exams")
    public ResponseEntity<Exam> createExam(@RequestBody ExamDto examDto, Principal principal) {
        return ResponseEntity.ok(examService.createExam(examDto, principal.getName()));
    }

    @GetMapping("/subjects-for-exam")
    public ResponseEntity<List<Subject>> getSubjectForScheduling(@RequestParam Integer semester,@RequestParam Long examId, Principal principal) {
        return ResponseEntity.ok(examService.getSubjectsForExam(principal.getName(), semester,examId));
    }

    @PostMapping("/exams/schedule")
    public ResponseEntity<ExamSchedule> createExamSchedule(@RequestBody ExamScheduleDto scheduleDto) {
        return ResponseEntity.ok(examService.createExamSchedule(scheduleDto));
    }

    @GetMapping("/exams")
    public ResponseEntity<List<Exam>> getExams(Principal principal) {
        return ResponseEntity.ok(examService.getExamsByHod(principal.getName()));
    }

    @GetMapping("/exams/{examId}/schedule")
    public ResponseEntity<List<ExamSchedule>> listSchedule(@PathVariable Long examId) {
        return ResponseEntity.ok(examScheduleRepository.findAllByExamId(examId));
    }

    @DeleteMapping("exams/{examId}/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long examId, @PathVariable Long scheduleId) {
        examScheduleRepository.deleteById(scheduleId);
        return ResponseEntity.noContent().build();
    }
}
