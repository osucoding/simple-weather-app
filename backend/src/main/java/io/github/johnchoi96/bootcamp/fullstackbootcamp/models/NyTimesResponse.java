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
public class NyTimesResponse {
    private String copyright;
    private String lastUpdated;
    private String section;
    private List<ResultsItem> results;
    private int numResults;
    private String status;
}