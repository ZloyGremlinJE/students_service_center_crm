package com.jm.students.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.students.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class GeocodingServiceHereImpl implements GeocodingService {

    private String hereMapsApiKey = "vLzuZVgjeNRt1lGlVutRAQWCli2hPzcHenxs9gcxdtk";

    private String hereMapsApiUrl = "https://geocode.search.hereapi.com/v1/geocode";

    public void setHereMapsApiUrl(String hereMapsApiUrl) {
        this.hereMapsApiUrl = hereMapsApiUrl;
    }

    public void setHereMapsApiKey(String hereMapsApiKey) {
        this.hereMapsApiKey = hereMapsApiKey;
    }

    @Override
    public Optional<Location> getLocation(String address) throws JsonProcessingException {
        Optional<Location> result = Optional.empty();
        RestTemplate restTemplate = new RestTemplate();
        String url = hereMapsApiUrl +
                "?q=" +
                address.replaceAll(" ", "+") +
                "&apiKey=" +
                hereMapsApiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readValue(response.getBody(), JsonNode.class);
        }


        return result;
    }
}
