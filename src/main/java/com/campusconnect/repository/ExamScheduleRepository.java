package com.campusconnect.repository;

import com.campusconnect.entity.ExamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ExamScheduleRepository extends JpaRepository<ExamSchedule, Long> {

    List<ExamSchedule> findByExamId(Long examId);

    List<ExamSchedule> findAllByExamId(Long examId);

    boolean existsByExamIdAndSubjectId(Long examId, Long subjectId);

    boolean existsByExamIdAndExamDateAndStartTime(Long examId, LocalDate examDate, LocalTime startTime);
}
