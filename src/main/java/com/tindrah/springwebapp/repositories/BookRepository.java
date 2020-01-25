package com.tindrah.springwebapp.repositories;

import com.tindrah.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
