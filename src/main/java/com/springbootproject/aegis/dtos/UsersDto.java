package com.springbootproject.aegis.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootproject.aegis.models.JobRole;
import com.springbootproject.aegis.models.ReportItem;
import lombok.Data;

import java.util.List;

@Data
public class UsersDto {

    private final Long id;
    private final String username;

    private final String password;
    private final String firstname;
    private final String lastname;
    private final String role;
    private final boolean enabled;
    private final JobRole job;
    private final List<ReportItem> reportItems;
}
