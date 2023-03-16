package io.github.johnchoi96.bootcamp.fullstackbootcamp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.client.WeatherClient;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.models.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/weather")
public class WeatherController {
    @Autowired
    private WeatherClient client;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam("cityName") final String cityName, @RequestParam("stateCode") final String stateCode, @RequestParam("countryCode") final String countryCode) throws JsonProcessingException {
        return ResponseEntity.ok(client.getWeather(cityName, stateCode, countryCode));
    }

}
