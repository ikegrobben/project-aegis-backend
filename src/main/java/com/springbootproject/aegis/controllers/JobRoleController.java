package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.JobRoleDto;
import com.springbootproject.aegis.services.JobRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRoleController {
    private final JobRoleService service;

    public JobRoleController(JobRoleService service) { this.service = service; }

    // Get all jobs
    @GetMapping("/positions")
    public ResponseEntity<Object> getJobRoles() {
        List<JobRoleDto> jobRoleList = service.getJobRoles();
        return new ResponseEntity<>(jobRoleList, HttpStatus.OK);
    }
}
