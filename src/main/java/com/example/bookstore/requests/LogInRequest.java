package com.example.bookstore.requests;

import lombok.Data;

@Data
public class LogInRequest {
    private String username;
    private String password;
}
