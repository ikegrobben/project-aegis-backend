package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.component.JwtRequestFilter;
import com.springbootproject.aegis.configuration.SecurityConfig;
import com.springbootproject.aegis.services.CategoryService;
import com.springbootproject.aegis.services.CategoryServiceImpl;
import com.springbootproject.aegis.services.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CategoryControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoryService categoryService;

    @MockBean
    JwtService jwtService;

    @MockBean
    DataSource dataSource;

    @Test
    public void shouldReturnCategoryList() throws Exception {

        Mockito.when(categoryService.getCategories());

       mockMvc.perform(MockMvcRequestBuilders
               .get("/categories")
               .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.categories").exists())
               .andExpect(MockMvcResultMatchers.jsonPath("$.categories[*].id").isNotEmpty());
    }
}
