package com.example.bookstore.controllers;

import com.example.bookstore.domain.Book;
import com.example.bookstore.responses.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
public class UserController {


    private final BookService bookService;

    public UserController(BookService bookService) {
        this.bookService = bookService;
    }






}




