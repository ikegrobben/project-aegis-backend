package com.springbootproject.aegis.dtos;

import com.springbootproject.aegis.models.Users;
import lombok.Data;

import java.util.List;

@Data
public class JobRoleDto {

    private final Long id;
    private final String name;
    private final List<Users> users;
}
