package com.campusconnect.dto;

import com.campusconnect.entity.Role;
import lombok.Data;

@Data
public class JwtResponse {
    private final String jwt;
    private Role role;

    public JwtResponse(String jwt, Role role) {
        this.jwt = jwt;
        this.role = role;
    }
}
