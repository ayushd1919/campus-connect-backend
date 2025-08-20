package com.campusconnect.repository;

import com.campusconnect.entity.ElectiveTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectiveTrackRepository extends JpaRepository<ElectiveTrack, Long> {
    List<ElectiveTrack> findByDepartmentId(Long departmentId);
}
