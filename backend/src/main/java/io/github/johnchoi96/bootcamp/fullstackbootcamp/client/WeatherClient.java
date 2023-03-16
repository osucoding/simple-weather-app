package io.github.johnchoi96.bootcamp.fullstackbootcamp.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.models.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherClient {

    @Value("${open-weather.apiKey}")
    private String apiKey;

    @Value("${open-weather.uri}")
    private String uri;

    /**
     * The possible section value are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @return response from API
     */
    public WeatherResponse getWeather(final String city, final String state, final String country) throws JsonProcessingException {
        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(String.format("%s?q=%s,%s,%s&appid=%s", uri, city, state, country, apiKey), String.class);

        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        WeatherResponse response = mapper.readValue(result, WeatherResponse.class);
        return response;
    }
}
