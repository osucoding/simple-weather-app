package io.github.johnchoi96.bootcamp.fullstackbootcamp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/sample")
public class SampleController {

    @GetMapping(value = "/sayHi", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHelloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/sayMyName", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHelloWithMyName(@RequestParam("name") final String name) {
        return "hello " + name + "!";
    }
}
