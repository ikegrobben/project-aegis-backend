package com.springbootproject.aegis.controllers;

import com.springbootproject.aegis.dtos.LocationDto;
import com.springbootproject.aegis.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) { this.service = service; }

    // Get all categories
    @GetMapping("/locations")
    public ResponseEntity<Object> getLocations() {
        List<LocationDto> locationList = service.getLocations();
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }
}
