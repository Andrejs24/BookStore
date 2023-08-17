package com.example.bookstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    private String description;
    private BigDecimal price;

    public Book(String title, Author author, String description, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }
}


