package com.example.bookstore.controllers;

import com.example.bookstore.domain.Book;
import com.example.bookstore.responses.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {


    private final BookService bookService;

    public UserController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> showAllBooks() {
        return bookService.showAllBooks();
    }


}




