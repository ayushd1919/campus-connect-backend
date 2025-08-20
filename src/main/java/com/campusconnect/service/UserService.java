package com.campusconnect.service;

import com.campusconnect.dto.AdminRegistrationDto;
import com.campusconnect.dto.FacultyRegistrationDto;
import com.campusconnect.dto.StudentRegistrationDto;
import com.campusconnect.entity.Department;
import com.campusconnect.entity.User;
import com.campusconnect.repository.DepartmentRepository;
import com.campusconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.campusconnect.entity.Role.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // --- USER REGISTRATION METHODS ---

    public User registerStudent(StudentRegistrationDto studentDto) {
        Department department = departmentRepository.findById(studentDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Error: Department is not found."));

        User newUser = new User();
        newUser.setName(studentDto.getName());
        newUser.setEmail(studentDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        newUser.setRole(STUDENT);
        newUser.setDepartment(department);
        newUser.setYear(studentDto.getYear());
        newUser.setDivision(studentDto.getDivision());
        newUser.setBatch(studentDto.getBatch());

        return userRepository.save(newUser);
    }

    public User registerAdmin(AdminRegistrationDto adminDto) {
        User newUser = new User();
        newUser.setName(adminDto.getName());
        newUser.setEmail(adminDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        newUser.setRole(ADMIN);

        return userRepository.save(newUser);
    }

    public User registerFaculty(FacultyRegistrationDto facultyDto) {
        Department department = departmentRepository.findById(facultyDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Error: Department is not found."));

        User newUser = new User();
        newUser.setName(facultyDto.getName());
        newUser.setEmail(facultyDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(facultyDto.getPassword()));

        // Check if the role from DTO is HOD, otherwise default to FACULTY
        if (facultyDto.getRole() == HOD) {
            newUser.setRole(HOD);
        } else {
            newUser.setRole(FACULTY);
        }

        newUser.setDepartment(department);

        return userRepository.save(newUser);
    }

    // --- USER MANAGEMENT METHODS ---

    public List<User> getAllFaculty() {
        // This will fetch both FACULTY and HOD roles
        return userRepository.findByRole(FACULTY);
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }
}
