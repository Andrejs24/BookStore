package com.example.bookstore.controllers;

import com.example.bookstore.domain.Book;
import com.example.bookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestingController {

    private final BookService bookService;

    public TestingController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> showAllBooks() {
        return bookService.showAllBooks();
    }
}
