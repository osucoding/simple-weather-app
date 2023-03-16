package io.github.johnchoi96.bootcamp.fullstackbootcamp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherItems {
    @JsonProperty(value = "main")
    private String weatherName;
}
