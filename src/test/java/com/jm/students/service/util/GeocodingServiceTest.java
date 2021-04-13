package com.jm.students.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jm.students.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;

class GeocodingServiceTest {

    private GeocodingService geocodingService;
    private double EPSILON = 0.1;

    @Test
    void getLocation() {
        geocodingService = new GeocodingServiceHereImpl();
        String address = "Москва 1-й Тушинский проезд, 14";
        Location trueGeocode = new Location(55.833966, 37.417257);
        Location geocode = geocodingService.getLocation(address)
                .orElse(new Location(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        double distance = Math.abs(trueGeocode.getLatitude() - geocode.getLatitude())
                + Math.abs(trueGeocode.getLongitude() - geocode.getLongitude());
        assertTrue(distance < EPSILON);
    }
}