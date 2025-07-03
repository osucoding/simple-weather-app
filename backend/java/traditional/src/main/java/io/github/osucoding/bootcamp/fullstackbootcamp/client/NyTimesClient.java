package io.github.osucoding.bootcamp.fullstackbootcamp.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NyTimesClient {

    @Value("${nytimes.apiKey}")
    private String apiKey;

    @Value("${nytimes.uri}")
    private String uri;

    /**
     * The possible section value are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @param sectionValue one of above
     * @return response from API
     * @throws JsonProcessingException
     */
    public NyTimesResponse getNews(final String sectionValue) throws JsonProcessingException {
        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(String.format("%s%s.json?api-key=%s", uri, sectionValue, apiKey), String.class);

        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        NyTimesResponse response = mapper.readValue(result, NyTimesResponse.class);
        return response;
    }
}
