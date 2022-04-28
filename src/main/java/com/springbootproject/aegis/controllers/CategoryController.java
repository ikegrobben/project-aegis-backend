package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.CategoryDto;

import com.springbootproject.aegis.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) { this.service = service; }

    // Get all categories
    @GetMapping("/categories")
    public ResponseEntity<Object> getCategories() {
        List<CategoryDto> categoryList = service.getCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
