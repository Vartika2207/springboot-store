package com.codebyvartika.store;

import com.codebyvartika.store.entities.User;
import com.codebyvartika.store.repositories.UserRepository;
import com.codebyvartika.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        System.out.println("Store application started.....");

        var service = context.getBean(UserService.class);
        service.manageProducts();
        service.manageProductDelete();


    }

}
