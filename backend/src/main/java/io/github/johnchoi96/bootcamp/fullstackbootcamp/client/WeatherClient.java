package io.github.johnchoi96.bootcamp.fullstackbootcamp.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.github.johnchoi96.bootcamp.fullstackbootcamp.models.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClient {

    @Value("${open-weather.apiKey}")
    private String apiKey;

    @Value("${open-weather.uri}")
    private String uri;

    public WeatherResponse getWeather(final String cityName, final String stateCode, final String countryCode) throws JsonProcessingException {
        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(String.format("%s?q=%s,%s,%s&appid=%s", uri, cityName, stateCode, countryCode, apiKey), String.class);

        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return mapper.readValue(result, WeatherResponse.class);
    }
}
