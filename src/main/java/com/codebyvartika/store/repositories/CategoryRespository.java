package com.codebyvartika.store.repositories;

import com.codebyvartika.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRespository extends CrudRepository<Category, Long> {
}
