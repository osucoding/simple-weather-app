package io.github.osucoding.bootcamp.fullstackbootcamp.handlers;

import io.github.osucoding.bootcamp.fullstackbootcamp.models.NyTimesResponse;
import io.github.osucoding.bootcamp.fullstackbootcamp.services.NyTimesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NyTimesHandler {

    private final NyTimesService nyTimesService;

    public Mono<ServerResponse> getNews(final ServerRequest serverRequest) {
        final Optional<String> optionalSectionValue = serverRequest.queryParam("sectionValue");
        if (optionalSectionValue.isEmpty()) {
            return ServerResponse.badRequest().bodyValue("Missing required query parameter: sectionValue");
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(nyTimesService.getNews(optionalSectionValue.get()), NyTimesResponse.class);
    }
}
