package com.campusconnect.repository;

import com.campusconnect.entity.Department;
import com.campusconnect.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByDepartment(Department department);
}
