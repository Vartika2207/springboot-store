package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
