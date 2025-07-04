package io.github.osucoding.bootcamp.fullstackbootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
public class SimpleWeatherAppReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWeatherAppReactiveApplication.class, args);
    }

    @Bean
    public WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // match all paths
                        .allowedOrigins("*") // allow all origins
                        .allowedMethods("*") // allow all HTTP methods
                        .allowedHeaders("*"); // allow all headers
            }
        };
    }
}
