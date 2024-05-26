package com.hyundai.webfluxstudy.repositories;

import com.hyundai.webfluxstudy.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
