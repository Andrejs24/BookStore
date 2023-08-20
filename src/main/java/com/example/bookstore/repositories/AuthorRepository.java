package com.example.bookstore.repositories;

import com.example.bookstore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Author a " +
            "WHERE a.firstName = :firstName " +
    "and a.lastName = :lastName")
    boolean isAuthorExist(@Param("firstName") String firstName,
                          @Param("lastName") String lastName);

    Author findByFirstNameAndLastName(String firstName, String lastName);

}
