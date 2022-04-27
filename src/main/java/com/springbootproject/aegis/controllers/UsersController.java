package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.UsersDto;

import com.springbootproject.aegis.models.ChangePassword;
import com.springbootproject.aegis.models.Users;
import com.springbootproject.aegis.services.JwtService;
import com.springbootproject.aegis.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private final UsersService service;

    private UsersDto usersDto;

    public UsersController(UsersService service) { this.service = service;};

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Object> signIn(@RequestBody UsersDto usersDto) {
        UsernamePasswordAuthenticationToken up = new UsernamePasswordAuthenticationToken(usersDto.getUsername(), usersDto.getPassword());
        Authentication auth = authManager.authenticate(up);
        UserDetails ud = (UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(ud);
        System.out.println(token);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body("Bearer " + token);
    }

     // Get report item
    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        List<UsersDto> usersList = service.getUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<Object> getUsers(@PathVariable(name = "name") String name) {
        Users users = service.getUser(name);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

     // Create new user
    @PostMapping("/create-user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UsersDto usersDto, BindingResult br) throws IOException {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        if(usersDto.getUsername().equals(service.getUser(usersDto.getUsername()).getUsername())) {
            return new ResponseEntity<>("That username already exists", HttpStatus.CONFLICT);
        }
        else {
            service.createUser(usersDto);
            return new ResponseEntity<>("New user created", HttpStatus.CREATED);

        }
    }

    // Deactivate user
    @DeleteMapping("/users/{id}/deactivate")
    public ResponseEntity<Object> deactivateUser(@PathVariable("id") Long id) {
        service.deactivateUser(id);
        return new ResponseEntity<>("User with id: " + id + " has been deactivated", HttpStatus.OK);
    }

    @PutMapping("/users/{id}/password")
    public ResponseEntity<Object> updatePassword(@PathVariable Long id, @RequestBody ChangePassword changePassword) {
        service.updatePassword(changePassword, id);
        return new ResponseEntity<>("password changed", HttpStatus.OK);
    }

}
