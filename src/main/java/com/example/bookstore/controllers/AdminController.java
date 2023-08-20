package com.example.bookstore.controllers;

import com.example.bookstore.domain.Book;
import com.example.bookstore.requests.CreateBookRequest;
import com.example.bookstore.requests.SearchBookRequest;
import com.example.bookstore.responses.BookService;
import org.springframework.data.domain.Page;
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
    public String addBook(@RequestBody CreateBookRequest request){
        bookService.createBook(request);
        return "Book created successfully!";
    }

//    @GetMapping("/books")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Book> showAllBooks(){
//     return  bookService.showAllBooks();
//    }

    @GetMapping("/books")
    public Page<Book> getBooks(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "50") int size) {
        return bookService.getBooks(page, size);
    }


}
