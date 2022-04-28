package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getCategories();
}
