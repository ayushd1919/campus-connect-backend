package com.campusconnect.dto;

import com.campusconnect.entity.Role;
import lombok.Data;

@Data
public class AdminRegistrationDto {
    private String name;
    private String email;
    private String password;
}
