package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    //    String
    //    select * from product where name = ?
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);


    //    number
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //    Nullable col
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //    multiple condition
    List<Product> findByDescriptionNullAndNameNull();
    List<Product> findByDescriptionNullAndNameNotNull();

    //  sort data (ORDER BY)
    List<Product> findByNameOrderByPriceAsc(String name);
    List<Product> findByNameOrderByPriceDesc(String name);

    //  limit   (TOP/FIRST)
    List<Product> findTop5ByNameOrderByPriceAsc(String name);
    List<Product> findTop5ByNameLikeOrderByPriceAsc(String name);



}
