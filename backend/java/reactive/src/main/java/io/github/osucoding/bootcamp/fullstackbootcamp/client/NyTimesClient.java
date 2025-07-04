package io.github.osucoding.bootcamp.fullstackbootcamp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NyTimesClient {

    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    @Value("${nytimes.apiKey}")
    private String apiKey;

    @Value("${nytimes.uri}")
    private String uri;

    public NyTimesClient(final WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    /**
     * The possible section values are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @param sectionValue one of above
     * @return reactive Mono of NyTimesResponse
     */
    public Mono<NyTimesResponse> getNews(final String sectionValue) {
        final String url = String.format("%s%s.json?api-key=%s", uri, sectionValue, apiKey);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(json -> {
                    try {
                        NyTimesResponse response = objectMapper.readValue(json, NyTimesResponse.class);
                        return Mono.just(response);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                });
    }
}