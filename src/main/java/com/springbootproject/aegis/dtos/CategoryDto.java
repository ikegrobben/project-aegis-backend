package com.springbootproject.aegis.dtos;

import com.springbootproject.aegis.models.ReportItem;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private final int id;
    private final String name;
    private final List<ReportItem> reportItem;

}
