package com.campusconnect.service;

import com.campusconnect.dto.SubjectDto;
import com.campusconnect.entity.Department;
import com.campusconnect.entity.ElectiveTrack;
import com.campusconnect.entity.Subject;
import com.campusconnect.repository.DepartmentRepository;
import com.campusconnect.repository.ElectiveTrackRepository;
import com.campusconnect.repository.SubjectRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.ServiceUI;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ElectiveTrackRepository electiveTrackRepository;

    public Subject createSubject(SubjectDto subjectDto) {
        Department department = departmentRepository.findById(subjectDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        ElectiveTrack electiveTrack = null;
        if(subjectDto.getElectiveTrackId() != null) {
            electiveTrack = electiveTrackRepository.findById(subjectDto.getElectiveTrackId())
                    .orElseThrow(() -> new RuntimeException("Elective Track not found"));
        }

        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subject.setSubjectCode(subjectDto.getSubjectCode());
        subject.setDepartment(department);
        subject.setType(subjectDto.getType());
        subject.setElectiveTrack(electiveTrack);
        subject.setHasIaExam(subjectDto.isHasIaexam());
        subject.setHasSemesterExam(subjectDto.isHasSemesterExam());
        subject.setHasPracticalExam(subjectDto.isHasPracticalExam());
        subject.setHasVivaExam(subjectDto.isHasVivaExam());

        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getSubjectByDepartment(Long departmentId) {
        return subjectRepository.findByDepartmentId(departmentId);
    }

    public List<Subject> getSubjectsBySemester(Integer semester) {
        return subjectRepository.findBySemester(semester);
    }

    public List<Subject> getSubjectsByDepartmentAndSemester(Long departmentId, Integer semester) {
        return subjectRepository.findByDepartmentIdAndSemester(departmentId,semester);
    }

    public Subject updateSubject(Long subjectId, SubjectDto subjectDto) {
        Subject existingSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Department department = departmentRepository.findById(subjectDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        ElectiveTrack electiveTrack = null;
        if(subjectDto.getElectiveTrackId() != null) {
            electiveTrack =  electiveTrackRepository.findById(subjectDto.getElectiveTrackId())
                    .orElseThrow(() -> new RuntimeException("Elective Track not found"));
        }

        existingSubject.setName(subjectDto.getName());
        existingSubject.setSubjectCode(subjectDto.getSubjectCode());
        existingSubject.setDepartment(department);
        existingSubject.setType(subjectDto.getType());
        existingSubject.setSemester(subjectDto.getSemester());
        existingSubject.setElectiveTrack(electiveTrack);
        existingSubject.setHasVivaExam(subjectDto.isHasVivaExam());
        existingSubject.setHasSemesterExam(subjectDto.isHasSemesterExam());
        existingSubject.setHasPracticalExam(subjectDto.isHasPracticalExam());
        existingSubject.setHasIaExam(subjectDto.isHasIaexam());

        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(Long subjectId) {
        if(!subjectRepository.existsById(subjectId)) {
            throw new RuntimeException("Subject not found");
        }
        subjectRepository.deleteById(subjectId);
    }

}


