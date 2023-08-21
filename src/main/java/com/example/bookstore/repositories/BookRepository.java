package com.example.bookstore.repositories;

import com.example.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository <Book,Long> {

Book findById(long id);

     @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Book b " +
             "WHERE b.title = :title " +
             "AND b.author.firstName = :authorFirstName " +
             "AND b.author.lastName = :authorLastName ")
     Boolean  findByTitleAndAuthor( @Param("title") String title,
     @Param("authorFirstName") String authorFirstName,
     @Param("authorLastName") String authorLastName);

}
