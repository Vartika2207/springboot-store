package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
