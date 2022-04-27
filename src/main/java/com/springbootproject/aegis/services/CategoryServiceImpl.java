package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.CategoryDto;

import com.springbootproject.aegis.models.Category;
import com.springbootproject.aegis.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {this.repository = repository; }

    // Create a list of all Categories
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> lc = this.repository.findAll();
        List<CategoryDto> categories = new ArrayList<>();

        lc.forEach(c -> categories.add(new CategoryDto(c.getId(), c.getName(), c.getReportItem())));
        return categories;
    }

    @Override
    public List<CategoryDto> getCategoriesByMonth(String monthName) {
        List<Category> lc = this.repository.findAll();
        List<CategoryDto> categories = new ArrayList<>();

        lc.forEach(c -> categories.add(new CategoryDto(c.getId(), c.getName(), c.getReportItem())));
        return categories;
    }
}
