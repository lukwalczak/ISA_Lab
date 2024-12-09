package org.example.simplerpggateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
            @Value("${rpg.gatewy.host}") String host
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


}
