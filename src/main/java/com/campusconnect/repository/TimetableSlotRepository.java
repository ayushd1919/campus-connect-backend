package com.campusconnect.repository;

import com.campusconnect.entity.Department;
import com.campusconnect.entity.TimetableSlot;
import com.campusconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface TimetableSlotRepository extends JpaRepository<TimetableSlot, Long> {

    List<TimetableSlot> findByDepartmentAndYearAndDivision(Department department, Integer year, String division);

    @Query("SELECT t FROM TimetableSlot t WHERE t.department = :department AND t.year = :year AND t.division = :division AND (t.batch IS NULL OR t.batch = :batch)")
    List<TimetableSlot> findStudentTimetable(@Param("department") Department department, @Param("year") Integer year, @Param("division") String diviison, @Param("batch") String batch);

    List<TimetableSlot> findByFacultyAndDayOfWeek(User faculty, DayOfWeek dayOfWeek);
}
