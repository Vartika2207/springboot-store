package com.codebyvartika.store;

import com.codebyvartika.store.entities.User;
import com.codebyvartika.store.repositories.UserRepository;
import com.codebyvartika.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        System.out.println("Store application started.....");

        var service = context.getBean(UserService.class);
//        service.manageProducts();
//        service.updateProductPrices();
//        service.fetchProducts();
//        service.fetchUser();
//        service.fetchUsers();
//        service.fetchProducts();
//        service.fetchProductsByCriteria();
//        service.fetchProductBySpecification("Bear", BigDecimal.valueOf(2), null);
//        service.fetchSortedProducts();
        service.fetchPaginatedProducts(0,3);
    }

}
