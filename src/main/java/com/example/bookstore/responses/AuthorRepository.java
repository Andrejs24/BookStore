package com.example.bookstore.responses;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
