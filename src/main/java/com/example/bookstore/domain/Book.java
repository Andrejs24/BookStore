package com.example.bookstore.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;
    @ManyToOne

    private Author author;
    @NotNull
    @NotBlank
    @NotEmpty
    private String description;
    private BigDecimal price;

    public Book(String title, Author author, String description, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }
}


