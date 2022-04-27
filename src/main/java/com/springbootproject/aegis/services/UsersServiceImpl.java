package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.ReportItemDto;
import com.springbootproject.aegis.dtos.UsersDto;
import com.springbootproject.aegis.models.ChangePassword;
import com.springbootproject.aegis.models.ReportItem;
import com.springbootproject.aegis.models.Users;
import com.springbootproject.aegis.repositories.UsersRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) { this.repository = repository;};
    @Override
    public List<UsersDto> getUsers() {
        List<Users> lu = this.repository.findAll();
        List<UsersDto> users = new ArrayList<>();

        lu.forEach(u -> users.add(new UsersDto(u.getId(), u.getUsername(), u.getPassword(), u.getFirstname(), u.getLastname(), u.getRole(), u.isEnabled(), u.getJob(), u.getReportItems())));
        return users;
    }

    @Override
    public Users createUser(UsersDto usersDto) {
        Users user = new Users();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usersDto.getPassword());
        user.setUsername(usersDto.getUsername());
        user.setPassword(encodedPassword);
        user.setFirstname(usersDto.getFirstname());
        user.setLastname(usersDto.getLastname());
        user.setRole((usersDto.getRole()));
        user.setEnabled(true);
        user.setJob(usersDto.getJob());
    return this.repository.save(user);
    }

    @Override
    public Users getUser(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public void deactivateUser(Long id) {
         Users user = repository.findById(id).get();
         user.setEnabled(!user.isEnabled());
         this.repository.save(user);
    }

    @Override
    public Users updatePassword(ChangePassword changePassword, Long id) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String oldPassword = passwordEncoder.encode(changePassword.getOldPassword());
        String newPassword = passwordEncoder.encode(changePassword.getNewPassword());
        return this.repository.findById(id).map(user -> {
            if(passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {
                user.setPassword(newPassword);
                return this.repository.save(user);
            }
            return this.repository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found : " + id));
    }
}
