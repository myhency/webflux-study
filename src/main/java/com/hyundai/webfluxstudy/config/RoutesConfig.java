package com.hyundai.webfluxstudy.config;

import com.hyundai.webfluxstudy.handlers.ProductHandler;
import com.hyundai.webfluxstudy.model.Product;
import com.hyundai.webfluxstudy.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return route()
                .GET("/products/all", productHandler::getAll)
                .build();
    }
}
