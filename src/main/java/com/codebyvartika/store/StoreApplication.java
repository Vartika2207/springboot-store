package com.codebyvartika.store;

import com.codebyvartika.store.entities.Address;
import com.codebyvartika.store.entities.Profile;
import com.codebyvartika.store.entities.Tag;
import com.codebyvartika.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        System.out.println("StoreApplication started");
        var user = User.builder()
                .name("John")
                .password("1234")
                .email("email")
        .build();

        var address = Address.builder()
                .street("street")
                .zip("zip")
                .city("city")
                .state("state")
                .build();

//        user.getAddresses().add(address);
//        address.setUser(user);
        user.addAddress(address);
        System.out.println("user: " + user);
        System.out.println("address: " + address);


        var profile = Profile.builder()
                .bio("Hello its Me!")
                .phoneNumber("12345")
//                .dateOfBirth()
                .loyaltyPoints(23)
                .build();

        var tag = Tag.builder()
                .name("#Trend")
                .build();


    }
}
