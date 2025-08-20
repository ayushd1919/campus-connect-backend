package com.campusconnect.repository;

import com.campusconnect.entity.Department;
import com.campusconnect.entity.Subject;
import com.campusconnect.entity.Subject.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByDepartmentId(Long departmentId);
    List<Subject> findByType(SubjectType type);
    List<Subject> findByDepartmentAndType(Department department,SubjectType type);
    List<Subject> findBySemester(Integer semester);
    List<Subject> findByDepartmentIdAndSemester(Long departmentId, Integer semester);
    List<Subject> findByDepartmentIdAndSemesterAndHasSemesterExamTrue(Long departmentId, Integer semester);
    List<Subject> findByDepartmentIdAndSemesterAndHasIaExamTrue(Long departmentId, Integer semester);
    List<Subject> findByDepartmentIdAndSemesterAndHasPracticalExamTrue(Long departmentId, Integer semester);
    List<Subject> findByDepartmentIdAndSemesterAndHasVivaExamTrue(Long departmentId, Integer semester);

}
