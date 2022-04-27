package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.LocationDto;
import com.springbootproject.aegis.models.Location;
import com.springbootproject.aegis.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {this.repository = repository; }

    // Create a list of all Locations
    @Override
    public List<LocationDto> getLocations() {
        List<Location> ll = this.repository.findAll();
        List<LocationDto> locations = new ArrayList<>();

        ll.forEach(l -> locations.add(new LocationDto(l.getId(), l.getName(), l.getReportItem())));
        return locations;
    }
}
