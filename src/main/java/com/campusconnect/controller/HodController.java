package com.campusconnect.controller;

import com.campusconnect.dto.ExamDto;
import com.campusconnect.dto.ExamScheduleDto;
import com.campusconnect.dto.HodDashboardDto;
import com.campusconnect.dto.SubjectDto;
import com.campusconnect.entity.Exam;
import com.campusconnect.entity.ExamSchedule;
import com.campusconnect.entity.Subject;
import com.campusconnect.repository.ExamScheduleRepository;
import com.campusconnect.repository.SubjectRepository;
import com.campusconnect.service.ExamService;
import com.campusconnect.service.HodDashboardService;
import com.campusconnect.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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
    @Autowired
    private SubjectService subjectService;

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
    public ResponseEntity<ExamSchedule> createExamSchedule(@RequestBody ExamScheduleDto scheduleDto,Principal principal) {
        return ResponseEntity.ok(examService.createExamSchedule(scheduleDto, principal.getName()));
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
    // ===== SUBJECT MANAGEMENT (HOD-scoped) =====
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> hodListSubjects(
            @RequestParam(required = false) Integer semester, Principal principal) {
        return ResponseEntity.ok(subjectService.hodListSubjects(principal.getName(),semester));
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> hodCreateSubject(@RequestBody SubjectDto dto, Principal principal) {
        return ResponseEntity.ok(subjectService.hodCreateSubject(principal.getName(), dto));
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> hodUpdateSubject(
            @PathVariable Long id,
            @RequestBody SubjectDto dto,
            Principal principal) {
        return ResponseEntity.ok(subjectService.hodUpdateSubject(principal.getName(),id,dto));
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Void> hodDeleteSubject(@PathVariable Long id, Principal principal) {
        subjectService.hodDeleteSubject(principal.getName(),id);
        return ResponseEntity.noContent().build();
    }
}
