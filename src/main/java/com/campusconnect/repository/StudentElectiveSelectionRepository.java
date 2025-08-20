package com.campusconnect.repository;

import com.campusconnect.entity.StudentElectiveSelection;
import com.campusconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentElectiveSelectionRepository extends JpaRepository<StudentElectiveSelection, Long> {
    List<StudentElectiveSelection> findByStudent(User student);

    boolean existsByStudentAndDlocTrackIsNotNull(User student);

    boolean existsByStudentAndIlocTrackIsNotNull(User student);
}
