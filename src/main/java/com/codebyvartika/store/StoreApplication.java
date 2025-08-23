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
        System.out.println("Store application started.....");

        var repository = context.getBean(UserRepository.class);
        var user = repository.findById(1L).orElseThrow();
        System.out.println(user.getEmail());

        repository.findAll().forEach(u -> System.out.println(u.getName()));

//        var user = User.builder()
//                .name("John1")
//                .email("john1@gmail.com")
//                .password("Pass123455")
//                .build();
//        repository.save(user);

    }

}
