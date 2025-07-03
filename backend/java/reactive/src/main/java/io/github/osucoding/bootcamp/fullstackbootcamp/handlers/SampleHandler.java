package io.github.osucoding.bootcamp.fullstackbootcamp.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class SampleHandler {

    public Mono<ServerResponse> getHelloWorld(final ServerRequest ignoredServerRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("hello world"));
    }

    public Mono<ServerResponse> sayHelloWithMyName(final ServerRequest serverRequest) {
        final Optional<String> optionalNameRequestParameter = serverRequest.queryParam("name");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("hello " + optionalNameRequestParameter.orElse("N/A") + "!"));
    }
}
