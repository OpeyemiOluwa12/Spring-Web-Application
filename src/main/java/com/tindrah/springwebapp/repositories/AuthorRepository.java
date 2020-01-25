package com.tindrah.springwebapp.repositories;

import com.tindrah.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
