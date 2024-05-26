package com.hyundai.webfluxstudy.services;

import com.hyundai.webfluxstudy.model.Product;
import com.hyundai.webfluxstudy.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getProducts() { // whole method takes 10 seconds to execute
        return productRepository.findAll() // 2 products
                .delayElements(Duration.ofSeconds(5)); // for any element add a sleep duration
    }

    public Flux<Product> getAll() {
        var p1 = new Product();
        p1.setName("Cola");
        var p2 = new Product();
        p2.setName("Water");

        return Flux.fromStream(Stream.of(p1, p2))
                .delayElements(Duration.ofSeconds(3)); // simulate something happens with each product
    }
}
