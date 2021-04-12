package com.jm.students.service.util;

import com.jm.students.model.Location;

import java.util.Optional;

public interface GeocodingService {
    Optional<Location> getLocation(String address);
}
