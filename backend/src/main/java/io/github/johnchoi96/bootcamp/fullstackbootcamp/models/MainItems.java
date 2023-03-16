package io.github.johnchoi96.bootcamp.fullstackbootcamp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainItems {
    private Double temp;
}
