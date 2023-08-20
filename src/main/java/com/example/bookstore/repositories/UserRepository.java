package com.example.bookstore.repositories;

import com.example.bookstore.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {
    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
