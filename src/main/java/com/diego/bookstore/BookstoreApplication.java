package com.diego.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.bookstore.domain.Book;
import com.diego.bookstore.domain.Category;
import com.diego.bookstore.repository.BookRepository;
import com.diego.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);	
		
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática", "Livro de TI");
		
		Book book1 = new Book(null, "Clean Code", "Robert Martion", "Lorem ipsum", cat1);
		
		cat1.getBooks().addAll(Arrays.asList(book1));
		
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(book1));
	}

}
