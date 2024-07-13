package com.hyundai.webfluxstudy.controllers;

import com.hyundai.webfluxstudy.holders.ReactiveRequestContextHolder;
import com.hyundai.webfluxstudy.model.Product;
import com.hyundai.webfluxstudy.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="/request", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Product> getRequest() {
        return ReactiveRequestContextHolder.getRequest()
                .map(request -> Objects.requireNonNull(request.getRemoteAddress()).getAddress().getHostAddress())
                .map(address -> {
                    var product = new Product();
                    product.setName(address);
                    return product;
                });



    }

    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts() {
        return productService.getProducts();
    }
}
