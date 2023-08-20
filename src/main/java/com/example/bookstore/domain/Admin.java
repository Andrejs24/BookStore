package com.example.bookstore.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Admin {
    @Value("${spring.security.user.name}")
    private final String defaultUsername;

    @Value("${spring.security.user.password}")
    private final String defaultPassword;
    private final String role = "ADMIN";


}
