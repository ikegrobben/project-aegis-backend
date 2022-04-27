package com.springbootproject.aegis.dtos;

import com.springbootproject.aegis.models.Category;
import com.springbootproject.aegis.models.Location;
import com.springbootproject.aegis.models.Report;
import com.springbootproject.aegis.models.Users;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ReportItemDto {
    private final long id;
    private final LocalDateTime reportItemDateTime;
    private final String content;
    private final String status;
    private final Category category;
    // Categories, Locations, Images, Users
    private final Report report;
    private final Location location;
    private final String image;
    private final Users users;
}
