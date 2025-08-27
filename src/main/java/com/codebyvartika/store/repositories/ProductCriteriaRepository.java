package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Category;
import com.codebyvartika.store.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {

    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
