package com.campusconnect.controller;

import com.campusconnect.entity.ElectiveTrack;
import com.campusconnect.entity.StudentElectiveSelection;
import com.campusconnect.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private ElectiveService electiveService;

    @GetMapping("/electives/dloc/tracks")
    public ResponseEntity<List<ElectiveTrack>> getAvailableDlocTrack(Principal principal) {
        return ResponseEntity.ok(electiveService.getAvailableDlocTracks(principal.getName()));
    }

    @GetMapping("/electives/iloc/tracks")
    public ResponseEntity<List<ElectiveTrack>> getAvailableIlocTrack() {
        return ResponseEntity.ok(electiveService.getAvailableIlocTracks());
    }

    @PostMapping("/electives/dloc/select/{trackId}")
    public ResponseEntity<StudentElectiveSelection> selectDlocTrack(Principal principal,@PathVariable Long trackId) {
        return ResponseEntity.ok(electiveService.selectDlocTrack(principal.getName(), trackId));
    }

    @PostMapping("/electives/iloc/select/{trackId}")
    public ResponseEntity<StudentElectiveSelection> selectIlocTrack(Principal principal, @PathVariable Long trackId, @RequestParam Integer semester) {
        return ResponseEntity.ok(electiveService.selectIlocTrack(principal.getName(), trackId));
    }
}
