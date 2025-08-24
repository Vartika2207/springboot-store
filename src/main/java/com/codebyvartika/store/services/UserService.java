package com.codebyvartika.store.services;

import com.codebyvartika.store.entities.User;
import com.codebyvartika.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

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
}
