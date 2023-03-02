package io.github.johnchoi96.bootcamp.fullstackbootcamp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsItem {
    private List<Object> perFacet;
    @JsonProperty(value = "abstract")
    private String abstractTitle;
    private String subsection;
    private String itemType;
    private List<String> orgFacet;
    private String section;
    private String jsonMemberAbstract;
    private String title;
    private List<String> desFacet;
    private String uri;
    private String url;
    private String shortUrl;
    private String materialTypeFacet;
    private List<MultimediaItem> multimedia;
    private List<String> geoFacet;
    private String updatedDate;
    private String createdDate;
    private String byline;
    private String publishedDate;
    private String kicker;
}