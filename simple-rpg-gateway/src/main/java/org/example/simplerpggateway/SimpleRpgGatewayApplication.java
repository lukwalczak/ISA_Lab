package org.example.simplerpggateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SimpleRpgGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRpgGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${rpg.character.url}") String characterUrl,
            @Value("${rpg.profession.url}") String professionUrl,
            @Value("${rpg.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("professions", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/professions/{uuid}",
                                "/api/professions"
                        )
                        .uri(professionUrl)
                )
                .route("characters", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/characters",
                                "/api/characters/**",
                                "/api/users/{uuid}/characters",
                                "/api/users/{uuid}/characters/**",
                                "/api/professions/{uuid}/characters",
                                "/api/professions/{uuid}/characters/**"
                        )
                        .uri(characterUrl)
                )
                .build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedOriginPattern("*"); // Allow all origins, restrict this in production
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        config.setAllowCredentials(true); // Allow credentials (e.g., cookies)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply CORS config to all paths

        return new CorsFilter(source);
    }
}
