package com.jm.students.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jm.students.model.Location;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface GeocodingService {
    Optional<Location> getLocation(String address) throws JsonProcessingException;
}
