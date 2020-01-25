package com.tindrah.springwebapp.bootstrap;

import com.tindrah.springwebapp.model.Author;
import com.tindrah.springwebapp.model.Book;
import com.tindrah.springwebapp.model.Publisher;
import com.tindrah.springwebapp.repositories.AuthorRepository;
import com.tindrah.springwebapp.repositories.BookRepository;
import com.tindrah.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData() {

        //Eric book
        Publisher dddPublisher = new Publisher("Harper Collins", "123, Hamper lane, Glasgow London United Kingdom");
        publisherRepository.save(dddPublisher);

        Author eric = new Author("Eric", "Evang");
        Book ddd = new Book("Domain Driven Design", "1234", dddPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod book
        Publisher noEJBPublisher = new Publisher("Worx", "24, Moric Moore street, Paris");
        publisherRepository.save(noEJBPublisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", noEJBPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);



    }


}
