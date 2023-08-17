package com.example.bookstore.requests;

import com.example.bookstore.domain.Author;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SearchBookRequest{

        @Valid
        private String title;
        @Valid
        private String author;
        @Valid
        private String description;
        @Valid
        private BigDecimal price;
}
