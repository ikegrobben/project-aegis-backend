package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.LocationDto;

import java.util.List;

public interface LocationService {
    public List<LocationDto> getLocations();
}
