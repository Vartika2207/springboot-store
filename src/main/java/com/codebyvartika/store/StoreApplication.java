package com.codebyvartika.store;

import com.codebyvartika.store.entities.User;
import com.codebyvartika.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var repository = context.getBean(UserRepository.class);

        var user = User.builder()
                .name("John")
                .email("john@gmail.com")
                .password("Pass123455")
                .build();
        repository.save(user);

    }

}
