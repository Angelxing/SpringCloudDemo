package com.xing.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service-auth", r -> r.path("/auth/**")
                        .uri("lb://service-auth"))
                .route("service-web", r -> r.path("/web/**")
                        .uri("lb://service-web"))
                .route("service-product", r -> r.path("/product/**")
                        .uri("lb://service-product"))
                .build();
    }
}
