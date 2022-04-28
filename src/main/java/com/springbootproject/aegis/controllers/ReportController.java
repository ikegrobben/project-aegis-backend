package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.ReportDto;
import com.springbootproject.aegis.models.Report;
import com.springbootproject.aegis.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) { this.service = service; }

    // Get Reports
    @GetMapping("/reports")
    public ResponseEntity<Object> getReports() {
        List<ReportDto> reportsList = service.getReports();
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }

    // Get all reports from a month.
    // Future usage for getting a overview of all reports in a single month.
    @GetMapping("/reports/{month}")
    public ResponseEntity<Object> getMonthReport(@PathVariable(name = "month") String monthName) {
        List<ReportDto> reportsList = service.getMonthReport(monthName);
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }

    // Get Report
    @GetMapping("/report/{id}")
    public ResponseEntity<Object> getReport(@PathVariable(name = "id") Long id) {
        List<ReportDto> report = service.getReport(id);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    // Get last Report
    @GetMapping("/report/last-report")
    public ResponseEntity<Object> getLastReport() {
        List<ReportDto> report = service.getLastReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
