package com.campusconnect.controller;

import com.campusconnect.dto.AdminRegistrationDto;
import com.campusconnect.dto.FacultyRegistrationDto;
import com.campusconnect.dto.StudentRegistrationDto;
import com.campusconnect.entity.User;
import com.campusconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/student")
    public ResponseEntity<User> registerUser(@RequestBody StudentRegistrationDto registrationDto) {
        User newUser = userService.registerStudent(registrationDto);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("register/admin")
    public ResponseEntity<User> registerAdmin(@RequestBody AdminRegistrationDto adminDto) {
        User newUser = userService.registerAdmin(adminDto);
        return ResponseEntity.ok(newUser);
    }

}
