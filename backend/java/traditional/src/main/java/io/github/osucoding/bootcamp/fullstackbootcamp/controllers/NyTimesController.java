package io.github.osucoding.bootcamp.fullstackbootcamp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import io.github.osucoding.bootcamp.fullstackbootcamp.services.NyTimesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/ny-times")
@RequiredArgsConstructor
public class NyTimesController {

    private final NyTimesService nyTimesService;

    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NyTimesResponse> getNews(@RequestParam("sectionValue") final String sectionValue) throws JsonProcessingException {
        return ResponseEntity.ok(nyTimesService.getNews(sectionValue));
    }
}
