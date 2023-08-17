package com.example.bookstore.controllers;

import com.example.bookstore.domain.Book;
import com.example.bookstore.requests.CreateBookRequest;
import com.example.bookstore.requests.SearchBookRequest;
import com.example.bookstore.responses.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody CreateBookRequest request){
        bookService.createBook(request);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> showAllBooks(){
     return  bookService.showAllBooks();
    }


}
