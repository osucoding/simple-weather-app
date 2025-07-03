package io.github.osucoding.bootcamp.fullstackbootcamp.routers;

import io.github.osucoding.bootcamp.fullstackbootcamp.handlers.NyTimesHandler;
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
public class NyTimesRouter {

    private final NyTimesHandler nyTimesHandler;

    @Bean
    public RouterFunction<ServerResponse> routeGetNews() {
        return RouterFunctions.route(
                RequestPredicates.GET("/api/v0/ny-times/news")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                nyTimesHandler::getNews
        );
    }
}
