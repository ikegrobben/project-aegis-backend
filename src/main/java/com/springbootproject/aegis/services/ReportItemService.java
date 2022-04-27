package com.springbootproject.aegis.services;


import com.springbootproject.aegis.dtos.ReportItemDto;
import com.springbootproject.aegis.models.ReportItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReportItemService {
    public ReportItem getReportItem(Long id);
    public ReportItem createReportItem(ReportItemDto reportItemDto, long reportId);
    public ReportItem updateReportItem(ReportItemDto reportItemDto, Long id);
    public List<ReportItemDto> getOpenReports();
    public List<ReportItemDto> getClosedReports();

    public List<ReportItemDto> getMonthReports(String monthName);

    void deleteReportItem(Long id);
}
