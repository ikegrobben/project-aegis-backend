package com.springbootproject.aegis.dtos;


import com.springbootproject.aegis.models.ReportItem;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReportDto {
    private final Long id;
    private final LocalDate reportDate;
    private final List<ReportItem> reportItems;
}
