package io.github.osucoding.bootcamp.fullstackbootcamp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsItem {
    @JsonProperty(value = "abstract")
    private String abstractTitle;

    private String url;

    private String byline;
}