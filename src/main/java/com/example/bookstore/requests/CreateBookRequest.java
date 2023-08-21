package com.example.bookstore.requests;

import com.example.bookstore.domain.Author;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookRequest {

    @NotEmpty
    @NotNull
    @NotBlank
    @Valid
    private String title;
    @NotNull
    @Valid
    private Author author;
    @Valid
    private String description;

    @Valid
    private BigDecimal price;


}
