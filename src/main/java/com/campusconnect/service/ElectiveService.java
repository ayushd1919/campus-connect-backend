package com.campusconnect.service;

import com.campusconnect.entity.ElectiveTrack;
import com.campusconnect.entity.StudentElectiveSelection;
import com.campusconnect.entity.User;
import com.campusconnect.repository.ElectiveTrackRepository;
import com.campusconnect.repository.StudentElectiveSelectionRepository;
import com.campusconnect.repository.SubjectRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveService {

    @Autowired private UserRepository userRepository;
    @Autowired private ElectiveTrackRepository electiveTrackRepository;
    @Autowired private StudentElectiveSelectionRepository selectionRepository;

    private static final Long COMMON_DEPARTMENT_ID = 7L;

    public List<ElectiveTrack> getAvailableDlocTracks(String studentEmail) {
        User student = userRepository.findByEmail(studentEmail)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return electiveTrackRepository.findByDepartmentId(student.getDepartment().getId());
    }

    public List<ElectiveTrack> getAvailableIlocTracks() {
        return electiveTrackRepository.findByDepartmentId(COMMON_DEPARTMENT_ID);
    }

    public StudentElectiveSelection selectDlocTrack(String studentEmail, Long trackId) {
        User student = userRepository.findByEmail(studentEmail)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (selectionRepository.existsByStudentAndDlocTrackIsNotNull(student)) {
            throw new IllegalStateException("Student has already selected a DLOC track.");
        }

        ElectiveTrack track = electiveTrackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("DLOC Track not found"));

        StudentElectiveSelection selection = new StudentElectiveSelection();
        selection.setStudent(student);
        selection.setDlocTrack(track);

        return selectionRepository.save(selection);
    }

    public StudentElectiveSelection selectIlocTrack(String studentEmail, Long trackId) {
        User student = userRepository.findByEmail(studentEmail)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (selectionRepository.existsByStudentAndIlocTrackIsNotNull(student)) {
            throw new IllegalStateException("Student has already selected an ILOC track.");
        }

        ElectiveTrack track = electiveTrackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("ILOC Track not found"));

        StudentElectiveSelection selection = new StudentElectiveSelection();
        selection.setStudent(student);
        selection.setIlocTrack(track);

        return selectionRepository.save(selection);
    }
}
