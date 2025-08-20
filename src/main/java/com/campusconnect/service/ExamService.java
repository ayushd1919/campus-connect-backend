package com.campusconnect.service;

import com.campusconnect.dto.ExamDto;
import com.campusconnect.dto.ExamScheduleDto;
import com.campusconnect.entity.Exam;
import com.campusconnect.entity.ExamSchedule;
import com.campusconnect.entity.Subject;
import com.campusconnect.entity.User;
import com.campusconnect.repository.ExamRepository;
import com.campusconnect.repository.ExamScheduleRepository;
import com.campusconnect.repository.SubjectRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ExamService {


    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamScheduleRepository examScheduleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public Exam createExam(ExamDto examDto, String hodEmail) {
        User hod = userRepository.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));

        Exam exam = new Exam();
        exam.setName(examDto.getName());
        exam.setSemester(examDto.getSemester());
        exam.setStartDate(examDto.getStartDate());
        exam.setEndDate(examDto.getEndDate());
        exam.setDepartment(hod.getDepartment());

        if(exam.getEndDate().isBefore(exam.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be bofore start date");
        }

        return examRepository.save(exam);
    }


    public List<Subject> getSubjectForScheduling(String hodEmail, Integer semester) {
        User hod = userRepository.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));
        return subjectRepository.findByDepartmentIdAndSemesterAndHasSemesterExamTrue(
                hod.getDepartment().getId(), semester);
    }

    public ExamSchedule createExamSchedule (ExamScheduleDto scheduleDto){
        Exam exam = examRepository.findById(scheduleDto.getExamId())
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        Subject subject = subjectRepository.findById(scheduleDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        // Validate same department & semester
        if(!subject.getDepartment().getId().equals(exam.getDepartment().getId())){
            throw new IllegalArgumentException("Subject is not in the HOD's department");
        }
        if(subject.getSemester() != exam.getSemester()){
            throw new IllegalArgumentException("Subject semester does not match with exam semester");
        }

        // Date inside exam window
        if(scheduleDto.getExamDate().isBefore(exam.getStartDate()) ||
            scheduleDto.getExamDate().isAfter(exam.getStartDate())) {
            throw new IllegalArgumentException("Exam date must be within the event window");
        }
        boolean exists = examScheduleRepository
                .existsByExamIdAndSubjectId(scheduleDto.getExamId(), scheduleDto.getSubjectId());
        if(exists) {
            throw new IllegalArgumentException("Schedule already exists for this subject");
        }

        LocalTime endTime = exam.getName().toLowerCase().contains("ia")
                ? scheduleDto.getStartTime().plusMinutes(90)
                : scheduleDto.getStartTime().plusHours(2);

        boolean slotTaken = examScheduleRepository
                .existsByExamIdAndExamDateAndStartTime(scheduleDto.getExamId(), scheduleDto.getExamDate(), scheduleDto.getStartTime());
        if(slotTaken) {
            throw new IllegalArgumentException("Another subject is already scheduled at this time");
        }
        ExamSchedule schedule = new ExamSchedule();
        schedule.setExam(exam);
        schedule.setSubject(subject);
        schedule.setExamDate(scheduleDto.getExamDate());
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(endTime);

        return examScheduleRepository.save(schedule);
    }

    public List<Exam> getExamsByHod(String hodEmail) {
        User hod = userRepository.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));
        return examRepository.findByDepartment(hod.getDepartment());
    }
    public List<Subject> getSubjectsForExam(String hodEmail, Integer semester, Long examId) {
        User hod = userRepository.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        Long departmentId = hod.getDepartment().getId();
        String name = exam.getName() == null ? "" : exam.getName().toLowerCase();

        if(name.contains("ia") || name.contains("internal")) {
            return subjectRepository.findByDepartmentIdAndSemesterAndHasIaExamTrue(departmentId,semester);
        } else if(name.contains("practical")){
            return subjectRepository.findByDepartmentIdAndSemesterAndHasPracticalExamTrue(departmentId,semester);
        } else if (name.contains("viva")) {
            return subjectRepository.findByDepartmentIdAndSemesterAndHasVivaExamTrue(departmentId,semester);
        } else if (name.contains("odd") || name.contains("even") || name.contains("semester")) {
            return subjectRepository.findByDepartmentIdAndSemesterAndHasSemesterExamTrue(departmentId,semester);
        }
        return subjectRepository.findByDepartmentIdAndSemester(departmentId,semester);
    }
}
