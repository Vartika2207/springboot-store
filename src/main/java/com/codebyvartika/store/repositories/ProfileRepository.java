package com.codebyvartika.store.repositories;
import com.codebyvartika.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
