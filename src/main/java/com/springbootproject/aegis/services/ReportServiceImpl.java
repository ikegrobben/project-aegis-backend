package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.ReportDto;
import com.springbootproject.aegis.models.Report;
import com.springbootproject.aegis.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReportRepository repository;

    public ReportServiceImpl(ReportRepository repository) { this.repository = repository;}

    // Get Reports
    @Override
    public List<ReportDto> getReports() {
        List<Report> lr = this.repository.findAll();
        List<ReportDto> reports = new ArrayList<>();

        lr.forEach(r -> reports.add(new ReportDto(r.getId(), r.getReportDate(), r.getReportItem())));
        return reports;
    }

    // Find reportId
    @Override
    public Report getReportId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ReportDto> getReport(Long id) {
        List<Report> lr = repository.findByIdEquals(id);
        List<ReportDto> lrd = new ArrayList<>();

        lr.forEach(r -> lrd.add(new ReportDto(r.getId(), r.getReportDate(), r.getReportItem())));
        return lrd;
    }



    // Find last report by sorting and putting the latest ID on top.
    @Override
    public Report checkLastReport() {
        return repository.findTopByOrderByIdDesc();
    }

    @Override
    public List<ReportDto> getLastReport() {
        List<Report> lr = repository.findFirstByOrderByIdDesc();
        List<ReportDto> lrd = new ArrayList<>();

        lr.forEach(r -> lrd.add(new ReportDto(r.getId(), r.getReportDate(), r.getReportItem())));
        return lrd;
    }

    // Get all reports from a month.
    @Override
    public List<ReportDto> getMonthReport(String monthName) {
        List<Report> lr = this.repository.findAll();
        List<ReportDto> reports = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, u", Locale.ENGLISH);
        LocalDate date = LocalDate.parse((monthName.substring(0, 1).toUpperCase() + monthName.substring(1)) + " 01, 2022", dateFormatter);


        for(int i = 0; i < lr.size(); i++) {
            if(lr.get(i).getReportDate().getMonth() == date.getMonth()) {
                reports.add(new ReportDto(lr.get(i).getId(), lr.get(i).getReportDate(), lr.get(i).getReportItem()));
                System.out.println(lr.get(i).getReportDate().getMonth() + "" + LocalDate.now().getMonth());
            }
        }

        return reports;
    }

    // Create a report
    public void createReports() {
        Report r = new Report();
        LocalDate ld = LocalDate.now();
        r.setReportDate(ld);
        r.setReportItem(r.getReportItem());
        this.repository.save(r);
    }


}
