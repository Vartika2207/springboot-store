package com.codebyvartika.store.services;

import com.codebyvartika.store.entities.*;
import com.codebyvartika.store.repositories.AddressRepository;
import com.codebyvartika.store.repositories.ProductRepository;
import com.codebyvartika.store.repositories.ProfileRepository;
import com.codebyvartika.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("Rohn")
                .email("Rohn@gmail.com")
                .password("Pass123456")
                .build();

        if(entityManager.contains(user))
            System.out.println("Exists -> Persistent");
        else
            System.out.println("Does not exist -> Transient/detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Exists -> Persistent");
        else
            System.out.println("Does not exist -> Transient/detached");
    }

    @Transactional
    public void showRelatedEntities() {
        var user = userRepository.findById(5L).orElseThrow();
        System.out.println("email id of user  " + user.getEmail());

        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println("profile has " + profile.getBio());

        var profile_email = profileRepository.findById(2L).orElseThrow();
        System.out.println("profile_email has " + profile_email.getUser().getEmail());
    }

    @Transactional
    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println("Address to email " + address.getUser().getEmail());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("vikalp")
                .email("vikalp@gmail.com")
                .password("Pass123456")
                .build();
        var address = Address.builder()
                .zip("12345")
                .state("state")
                .city("city")
                .street("street")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }


    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(1L);

        var user = userRepository.findById(16L).orElseThrow();
        var address = user.getAddresses().getFirst();
        System.out.println("address to be removed for user " +  user.getEmail());
        user.removeAddress(address);
        userRepository.save(user);
    }


    @Transactional
    public void manageProducts() {
        var user = userRepository.findById(1L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addFavoriteProduct);
        userRepository.save(user);

    }
}
