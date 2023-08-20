package com.example.bookstore.responses;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.repositories.AuthorRepository;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.requests.CreateBookRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void createBook(CreateBookRequest request) {
        if (!isBookAlreadyExist(request)) {
            if (!authorRepository.isAuthorExist(request.getAuthor().getFirstName(), request.getAuthor().getLastName())) {
                authorRepository.save(new Author(request.getAuthor().getFirstName(), request.getAuthor().getLastName(), request.getAuthor().getLanguage(), request.getAuthor().getBookCount()));
            }

            Author author = authorRepository.findByFirstNameAndLastName(request.getAuthor().getFirstName(), request.getAuthor().getLastName());

            Book book = new Book(request.getTitle(), author, request.getDescription(), request.getPrice());

            bookRepository.save(book);
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Such book already exist");
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> showAllAuthors() {
        return authorRepository.findAll();
    }

    public Book findBookById(long id) {
        try {
            return bookRepository.findById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No book with such id");
        }

    }

    public void deleteBookById(long id) {
        bookRepository.deleteById(findBookById(id).getId());
    }

    public boolean isBookAlreadyExist(CreateBookRequest request) {
        String title = request.getTitle();
        String authorFirstName = request.getAuthor().getFirstName();
        String authorLastName = request.getAuthor().getLastName();
        try {
            return bookRepository.findByTitleAndAuthor(title, authorFirstName, authorLastName);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Such book already exist");
        }

    }
    public Page<Book> getBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> booksPage = bookRepository.findAll(pageable);

        List<Book> sortedBooks = booksPage.getContent().stream()
                .sorted(Comparator.comparing(Book::getId))
                .collect(Collectors.toList());

        Collections.reverse(sortedBooks);

        return new PageImpl<>(sortedBooks, pageable, booksPage.getTotalElements());
    }

    public boolean isAuthorExist(CreateBookRequest request) {
        return authorRepository.isAuthorExist(request.getAuthor().getFirstName(), request.getAuthor().getLastName());
    }


}
