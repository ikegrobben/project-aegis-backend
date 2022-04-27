package com.springbootproject.aegis.repositories;

import com.springbootproject.aegis.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
