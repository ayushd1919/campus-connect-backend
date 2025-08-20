package com.campusconnect.dto;

import com.campusconnect.entity.Role;
import lombok.Data;

@Data
public class StudentRegistrationDto {
    private String name;
    private String email;
    private String password;
    private Role role;
    private Long departmentId;
    private Integer year;
    private String division;
    private String batch;
}
