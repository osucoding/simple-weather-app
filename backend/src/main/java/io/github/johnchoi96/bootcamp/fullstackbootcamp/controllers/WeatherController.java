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
@RequestMapping(value = "/api/v0/son")
public class WeatherController {
    
    @Autowired
    private WeatherClient client;

    @GetMapping(value = "/sayHi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("hello worldls");
    }

    @GetMapping(value = "/weather_son", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam("city") final String city, @RequestParam("state") final String state, @RequestParam("country") final String country) throws JsonProcessingException {
        return ResponseEntity.ok(client.getWeather(city, state, country));
    }
}
