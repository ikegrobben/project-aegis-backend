package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.ReportDto;
import com.springbootproject.aegis.dtos.ReportItemDto;
import com.springbootproject.aegis.models.ReportItem;
import com.springbootproject.aegis.services.ReportItemService;
import com.springbootproject.aegis.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReportItemController {
    private final ReportItemService service;

    private ReportDto reportDto;

    public ReportItemController(ReportItemService service) { this.service = service; }

    @Autowired
    private ReportService reportService;

    // Post report item
    @PostMapping("/report-item")
    public ResponseEntity<Object> createReportItem(@Valid @RequestBody ReportItemDto reportItem, BindingResult br) throws IOException {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        // Check if report of the current date exists in the DB and adds the report item to that report.
        // Else generate a new report with the current date and add report item to that report.
        if(reportService.checkLastReport() != null && reportService.checkLastReport().getReportDate().equals(LocalDate.now())) {
            long reportId = reportService.checkLastReport().getId();
            service.createReportItem(reportItem, reportId);
            return new ResponseEntity<>("Report exist, new item added", HttpStatus.CREATED);
        } else {
            reportService.createReports();
            long reportId = reportService.checkLastReport().getId();
            service.createReportItem(reportItem, reportId);
            return new ResponseEntity<>("Created new report, added report item", HttpStatus.CREATED);

        }
    }

    // Get report item
    @GetMapping("/report-item/{id}")
    public ResponseEntity<Object> getReportItem(@PathVariable(name = "id") Long reportItemId) {
        ReportItem reportItem = service.getReportItem(reportItemId);
        return new ResponseEntity<>(reportItem, HttpStatus.OK);
    }


    // Edit report item
    @PutMapping("report-item/{id}")
    public ResponseEntity<Object> updateReportItem(@PathVariable Long id, @RequestBody ReportItemDto reportItemDto) {
        service.updateReportItem(reportItemDto, id);

        return new ResponseEntity<>("Report item updated.", HttpStatus.OK);
    }

    // Delete post
    @DeleteMapping("/report-item/{id}/delete")
    public ResponseEntity<Object> deletePost(@PathVariable("id") Long id) {
        service.deleteReportItem(id);
        return new ResponseEntity<>("Report item " + id + " has been deleted", HttpStatus.OK);
    }

     //get all open status
    @GetMapping("report-items/open")
    public ResponseEntity<Object> getOpenReports() {
        List<ReportItemDto> reportItemList = service.getOpenReports();
        return new ResponseEntity<>(reportItemList, HttpStatus.OK);
    }

    //get all closed status
    @GetMapping("report-items/closed")
    public ResponseEntity<Object> getClosedReports() {
        List<ReportItemDto> reportItemList = service.getClosedReports();
        return new ResponseEntity<>(reportItemList, HttpStatus.OK);
    }

    // Get all reports from a month.
    @GetMapping("/report-items/{month}")
    public ResponseEntity<Object> getMonthReports(@PathVariable(name = "month") String monthName) {
        List<ReportItemDto> reportsList = service.getMonthReports(monthName);
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }
}

