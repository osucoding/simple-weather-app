package io.github.osucoding.bootcamp.fullstackbootcamp.services;

import io.github.osucoding.bootcamp.fullstackbootcamp.client.NyTimesClient;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NyTimesService {

    private final NyTimesClient client;

    /**
     * The possible section value are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @param sectionValue one of above
     * @return response from API
     */
    public Mono<NyTimesResponse> getNews(final String sectionValue) {
        return client.getNews(sectionValue.trim());
    }
}
