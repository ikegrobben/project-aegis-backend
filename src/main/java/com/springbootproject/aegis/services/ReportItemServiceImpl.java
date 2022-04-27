package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.ReportItemDto;
import com.springbootproject.aegis.models.Report;
import com.springbootproject.aegis.models.ReportItem;
import com.springbootproject.aegis.repositories.ReportItemRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class ReportItemServiceImpl implements ReportItemService {

    private final ReportItemRepository repository;

    @Autowired
    private ReportService reportService;

    public ReportItemServiceImpl(ReportItemRepository repository) { this.repository = repository;}

    // Get report item
    @Override
    public ReportItem getReportItem(Long id) {
        return repository.findById(id).get();
    }

    // Create a report item with the current date & time.
    @Override
    public ReportItem createReportItem(ReportItemDto reportItemDto, long reportId){
        LocalDateTime dateTime = LocalDateTime.now();
        ReportItem ri = new ReportItem();

        Report currentReportId = reportService.getReportId(reportId);
        ri.setReportItemDate(dateTime);
        ri.setContent(reportItemDto.getContent());
        ri.setStatus(reportItemDto.getStatus());
        ri.setReport(currentReportId);
        ri.setCategory(reportItemDto.getCategory());
        ri.setLocation(reportItemDto.getLocation());
        ri.setImage(reportItemDto.getImage());
        ri.setUser(reportItemDto.getUsers());

        return this.repository.save(ri);
    }

    // Edit report item
    @Override
    public ReportItem updateReportItem(ReportItemDto reportItemDto, Long id) {
        return this.repository.findById(id).map(reportItem -> {

            reportItem.setContent(reportItemDto.getContent());
            reportItem.setStatus(reportItemDto.getStatus());
            reportItem.setCategory(reportItemDto.getCategory());
            reportItem.setLocation(reportItemDto.getLocation());
            reportItem.setImage(reportItemDto.getImage());
        return this.repository.save(reportItem);
        }).orElseThrow(() -> new ResourceNotFoundException("Post not found : " + id));
    }

    @Override
    public List<ReportItemDto> getOpenReports() {
        List<ReportItem> lri = this.repository.findByStatus("Open");
        List<ReportItemDto> reportItemList = new ArrayList<>();

        lri.forEach(r -> reportItemList.add(new ReportItemDto(r.getId(), r.getReportItemDateTime(), r.getContent(), r.getStatus(), r.getCategory(), r.getReport(), r.getLocation(), r.getImage(), r.getUsers())));
        return reportItemList;
    }

    @Override
    public List<ReportItemDto> getClosedReports() {
        List<ReportItem> lri = this.repository.findByStatus("Closed");
        List<ReportItemDto> reportItemList = new ArrayList<>();

        lri.forEach(r -> reportItemList.add(new ReportItemDto(r.getId(), r.getReportItemDateTime(), r.getContent(), r.getStatus(), r.getCategory(), r.getReport(), r.getLocation(), r.getImage(), r.getUsers())));
        return reportItemList;
    }

    @Override
    public List<ReportItemDto> getMonthReports(String monthName) {
        List<ReportItem> lri = this.repository.findAllByOrderByCategoryNameAsc();
        List<ReportItemDto> reports = new ArrayList<>();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, u", Locale.ENGLISH);
        LocalDate date = LocalDate.parse((monthName.substring(0, 1).toUpperCase() + monthName.substring(1)) + " 01, 2022", dateFormatter);

        for(int i = 0; i < lri.size(); i++) {
            if(lri.get(i).getReportItemDateTime().getMonth() == date.getMonth()) {
                reports.add(new ReportItemDto(lri.get(i).getId(), lri.get(i).getReportItemDateTime(), lri.get(i).getContent(), lri.get(i).getStatus(), lri.get(i).getCategory(), lri.get(i).getReport(), lri.get(i).getLocation(), lri.get(i).getImage(), lri.get(i).getUsers()));
            }
        }
        return reports;

    }

    @Override
    public void deleteReportItem(Long id) {
        repository.deleteById(id);
    }


}
