package com.diego.bookstore.service;

import com.diego.bookstore.domain.Book;
import com.diego.bookstore.domain.Category;
import com.diego.bookstore.repository.BookRepository;
import com.diego.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public void initBD() {
        Category cat1 = new Category(null, "Informática", "Livro de TI");
        Category cat2 = new Category(null, "Ficção", "Ficção Científica");
        Category cat3 = new Category(null, "Biografia", "Livros de Biografia");

        Book book1 = new Book(null, "Clean Code", "Robert Martion", "Lorem ipsum", cat1);
        Book book2 = new Book(null, "Universo", "Diego Estefan", "Lorem ipsum", cat2);
        Book book3 = new Book(null, "Angela Davis", "Angela Davis", "Lorem ipsum", cat3);
        Book book4 = new Book(null, "Clean Code2", "Robert Martion", "Lorem ipsum", cat1);

        cat1.getBooks().addAll(Arrays.asList(book1, book4));
        cat2.getBooks().add(book2);
        cat3.getBooks().add(book3);

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
    }
}
