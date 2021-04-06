package com.jm.students.service.util;

import com.jm.students.model.Location;
import org.springframework.stereotype.Component;

@Component
public interface GeocodingService {
    Location getLocation(String address);
}
