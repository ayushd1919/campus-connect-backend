package com.campusconnect.service;

import com.campusconnect.dto.SubjectDto;
import com.campusconnect.entity.Department;
import com.campusconnect.entity.ElectiveTrack;
import com.campusconnect.entity.Subject;
import com.campusconnect.repository.DepartmentRepository;
import com.campusconnect.repository.ElectiveTrackRepository;
import com.campusconnect.repository.SubjectRepository;
import com.campusconnect.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

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
        subject.setHasIaExam(subjectDto.isHasIaExam());
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
        existingSubject.setHasIaExam(subjectDto.isHasIaExam());

        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(Long subjectId) {
        if(!subjectRepository.existsById(subjectId)) {
            throw new RuntimeException("Subject not found");
        }
        subjectRepository.deleteById(subjectId);
    }

    private Department getHodDepartment(String username) {
        var user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found "+username));
        var dept = user.getDepartment();
        if(dept == null) throw new RuntimeException("HOD user has no department");
        return dept;
    }

    public List<Subject> hodListSubjects(String username, Integer semester) {
        Department department = getHodDepartment(username);
        if(semester != null) {
            return subjectRepository.findByDepartmentIdAndSemester(department.getId(), semester);
        }
        return subjectRepository.findByDepartmentId(department.getId());
    }

    public Subject hodCreateSubject(String username, SubjectDto dto) {
        Department department = getHodDepartment(username);

        ElectiveTrack electiveTrack = null;
        if(dto.getElectiveTrackId() != null) {
            electiveTrack = electiveTrackRepository.findById(dto.getElectiveTrackId())
                    .orElseThrow(() -> new RuntimeException("Elective Track not found"));
        }
        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setSubjectCode(dto.getSubjectCode());
        subject.setDepartment(department);
        subject.setType(dto.getType());
        subject.setSemester(dto.getSemester());
        subject.setElectiveTrack(electiveTrack);
        subject.setHasIaExam(dto.isHasIaExam());
        subject.setHasSemesterExam(dto.isHasSemesterExam());
        subject.setHasVivaExam(dto.isHasVivaExam());
        subject.setHasPracticalExam(dto.isHasPracticalExam());

        return subjectRepository.save(subject);
    }
    public Subject hodUpdateSubject(String username, Long subjectId, SubjectDto dto) {
        Department dept = getHodDepartment(username);

        Subject existing = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (!existing.getDepartment().getId().equals(dept.getId())) {
            throw new RuntimeException("Forbidden: subject not in your department");
        }

        ElectiveTrack electiveTrack = null;
        if (dto.getElectiveTrackId() != null) {
            electiveTrack = electiveTrackRepository.findById(dto.getElectiveTrackId())
                    .orElseThrow(() -> new RuntimeException("Elective Track not found"));
        }

        existing.setName(dto.getName());
        existing.setSubjectCode(dto.getSubjectCode());
        existing.setType(dto.getType());
        existing.setSemester(dto.getSemester());
        existing.setElectiveTrack(electiveTrack);
        existing.setHasVivaExam(dto.isHasVivaExam());
        existing.setHasSemesterExam(dto.isHasSemesterExam());
        existing.setHasPracticalExam(dto.isHasPracticalExam());
        existing.setHasIaExam(dto.isHasIaExam());

        return subjectRepository.save(existing);
    }

    public void hodDeleteSubject(String username, Long subjectId) {
        Department dept = getHodDepartment(username);
        if (!subjectRepository.existsByIdAndDepartmentId(subjectId, dept.getId())) {
            throw new RuntimeException("Forbidden or subject not found");
        }
        subjectRepository.deleteById(subjectId);
    }
}


