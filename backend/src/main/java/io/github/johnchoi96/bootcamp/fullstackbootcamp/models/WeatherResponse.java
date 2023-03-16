package io.github.johnchoi96.bootcamp.fullstackbootcamp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private CoordItems coord;
    private MainItems main;
    private List<WeatherItems> weather;
}
