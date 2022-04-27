package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.ReportDto;
import com.springbootproject.aegis.models.Report;

import java.util.List;

public interface ReportService {
    public List<ReportDto> getReports();
    public List<ReportDto> getMonthReport(String monthName);
    public List<ReportDto> getReport(Long id);
    public Report getReportId(Long id);
    public Report checkLastReport();
    public void createReports();
    public List<ReportDto> getLastReport();
}
