package com.campusconnect.controller;

import com.campusconnect.dto.FacultyDashboardDto;
import com.campusconnect.service.FacultyDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyDashboardService dashboardService;

    @GetMapping("/dashboard")
    public ResponseEntity<FacultyDashboardDto> getDashboardData(Principal principal) {
        return ResponseEntity.ok(dashboardService.getDashboardData(principal.getName()));
    }
}
