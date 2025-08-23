package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
