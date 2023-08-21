package com.example.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String firstName;
    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;
    @NotNull
    @NotBlank
    @NotEmpty
    private String language;
    private int bookCount;

    public Author(String firstName, String lastName, String language, int bookCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.bookCount = bookCount;
    }
}
