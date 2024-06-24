package com.pragra.firstspring.bootstrap;

import com.pragra.firstspring.domain.Author;
import com.pragra.firstspring.domain.AuthorRepository;
import com.pragra.firstspring.domain.Book;
import com.pragra.firstspring.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book dd = new Book("Domain Driven design", "23q321");
        eric.getBooks().add(dd);
        dd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(dd);

        System.out.println("Number of books " + authorRepository.count());

    }
}
