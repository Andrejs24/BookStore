package com.example.bookstore.responses;

import com.example.bookstore.configurations.SecurityConfiguration;
import com.example.bookstore.domain.Users;
import com.example.bookstore.repositories.UserRepository;
import com.example.bookstore.requests.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService  {

    @Value("${spring.security.user.name}")
    private String defaultUsername;

    @Value("${spring.security.user.password}")
    private String defaultPassword;


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Users validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User with username " + username + " not found." ));
    }

    public Users saveUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public void deleteUser(Users users) {
        userRepository.delete(users);
    }

    public Optional<Users> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(users -> passwordEncoder.matches(password, users.getPassword()));
    }
    public Users createUser(SignUpRequest request) {
        Users users = new Users();
        users.setUsername(request.getUsername());
        users.setPassword(request.getPassword());
        users.setName(request.getName());
        users.setEmail(request.getEmail());
        users.setRole(SecurityConfiguration.USER);
        return users;
    }

    public boolean adminAuthentication(String username, String password) {
        return username.equals(defaultUsername) && password.equals(defaultPassword);
    }
}
