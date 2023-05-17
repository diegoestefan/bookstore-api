package com.diego.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
