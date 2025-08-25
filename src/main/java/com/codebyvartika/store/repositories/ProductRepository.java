package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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


    //    query - makes easy to write queries
    //    find products whose price are in a given range and sort by name, below are without and with @query
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

      @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
      List<Product> findProduct(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    //    below  using jpql
      @Query("select p from Product p where p.price between :min and :max order by p.name")
      List<Product> findProductUsingJPQL(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Transactional
    @Modifying // tell hibernate its update not select
    @Query("UPDATE Product p SET p.price = :newPrice WHERE p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice,
                               @Param("categoryId") Byte categoryId);
}
