package io.github.osucoding.bootcamp.fullstackbootcamp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.osucoding.bootcamp.fullstackbootcamp.client.SampleClient;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleClient client;

    /**
     * The possible section value are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @param sectionValue one of above
     * @return response from API
     * @throws JsonProcessingException if JSON could not be processed
     */
    public NyTimesResponse getNews(final String sectionValue) throws JsonProcessingException {
        return client.getNews(sectionValue.trim());
    }
}
