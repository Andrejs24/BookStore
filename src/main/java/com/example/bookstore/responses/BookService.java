package com.example.bookstore.responses;

import com.example.bookstore.domain.Book;
import com.example.bookstore.requests.CreateBookRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void createBook(CreateBookRequest request){
        Book createdBook = new Book(request.getTitle(),request.getAuthor(),request.getDescription(),request.getPrice());
bookRepository.save(createdBook);
    }

    public List<Book> showAllBooks(){
        return bookRepository.findAll();
    }
    public Book findBookById(long id) {
        try {
//            return bookRepository.findById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No book with such id");
        }
        return new Book();
    }

    public void deleteBookById(long id){
        bookRepository.deleteById(findBookById(id).getId());
    }

    public boolean isBookAlreadyExist(CreateBookRequest request){
        String title = request.getTitle();
        String Author;
//        bookRepository.findByTitleAndAuthor;
        return true;
    }





}
