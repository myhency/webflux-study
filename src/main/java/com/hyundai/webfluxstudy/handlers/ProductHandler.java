package com.hyundai.webfluxstudy.handlers;


import com.hyundai.webfluxstudy.model.Product;
import com.hyundai.webfluxstudy.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ProductHandler {

    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAll(), Product.class);
    }

    public Mono<ServerResponse> getAllWithProxy(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAllWithProxy(), Product.class);
    }
}
