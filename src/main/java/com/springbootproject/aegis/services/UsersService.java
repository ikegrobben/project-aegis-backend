package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.UsersDto;
import com.springbootproject.aegis.models.ChangePassword;
import com.springbootproject.aegis.models.Users;

import java.util.List;

public interface UsersService {
    List<UsersDto> getUsers();

    public Users createUser(UsersDto usersDto);

    Users getUser(String name);

    void deactivateUser(Long id);

    Users updatePassword(ChangePassword changePassword, Long id);
}
