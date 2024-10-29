package io.github.osucoding.bootcamp.fullstackbootcamp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import io.github.osucoding.bootcamp.fullstackbootcamp.services.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping(value = "/sayHi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("hello world");
    }

    @GetMapping(value = "/sayMyName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sayHelloWithMyName(@RequestParam("name") final String name) {
        return ResponseEntity.ok("hello " + name + "!");
    }

    @GetMapping(value = "/nyTimes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NyTimesResponse> getWeather(@RequestParam("sectionValue") final String sectionValue) throws JsonProcessingException {
        return ResponseEntity.ok(sampleService.getNews(sectionValue));
    }
}
