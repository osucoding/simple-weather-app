package io.github.osucoding.bootcamp.fullstackbootcamp.routers;

import io.github.osucoding.bootcamp.fullstackbootcamp.handlers.SampleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class SampleRouter {

    private final SampleHandler sampleHandler;

    @Bean
    public RouterFunction<ServerResponse> routeGetHelloWorld() {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/api/v0/sample/say-hello")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        sampleHandler::getHelloWorld
                );
    }

    @Bean
    public RouterFunction<ServerResponse> routeSayHelloWithMyName() {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/api/v0/sample/say-my-name")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        sampleHandler::sayHelloWithMyName
                );
    }
}
