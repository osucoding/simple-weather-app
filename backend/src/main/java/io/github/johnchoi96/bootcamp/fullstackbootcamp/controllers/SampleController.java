package io.github.johnchoi96.bootcamp.fullstackbootcamp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.client.SampleClient;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/sample")
public class SampleController {

    @Autowired
    private SampleClient client;

    @GetMapping(value = "/sayHi", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHelloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/sayMyName", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHelloWithMyName(@RequestParam("name") final String name) {
        return "hello " + name + "!";
    }

    @GetMapping(value = "/nyTimes", produces = MediaType.APPLICATION_JSON_VALUE)
    public NyTimesResponse getWeather(@RequestParam("sectionValue") final String sectionValue) throws JsonProcessingException {
        return client.getNews(sectionValue);
    }
}
