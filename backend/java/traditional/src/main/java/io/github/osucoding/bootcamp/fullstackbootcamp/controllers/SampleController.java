package io.github.osucoding.bootcamp.fullstackbootcamp.controllers;

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

    @GetMapping(value = "/say-hi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("hello world");
    }

    @GetMapping(value = "/say-my-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sayHelloWithMyName(@RequestParam("name") final String name) {
        return ResponseEntity.ok("hello " + name + "!");
    }
}
