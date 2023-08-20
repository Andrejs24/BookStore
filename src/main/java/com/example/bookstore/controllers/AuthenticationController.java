package com.example.bookstore.controllers;

import com.example.bookstore.domain.Users;
import com.example.bookstore.requests.AuthenticationRequest;
import com.example.bookstore.requests.SignUpRequest;
import com.example.bookstore.responses.AuthenticationResponse;
import com.example.bookstore.responses.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest request) {
        if (userService.adminAuthentication(request.getUsername(),request.getPassword())){
            return ResponseEntity.ok(new AuthenticationResponse(0L,"ADMIN","ADMIN"));
        }
        Optional<Users> userOptional = userService.validUsernameAndPassword(request.getUsername(), request.getPassword());
        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            return ResponseEntity.ok(new AuthenticationResponse(users.getId(), users.getName(), users.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthenticationResponse signUp(@Valid @RequestBody SignUpRequest request) {
        if (userService.hasUserWithUsername(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User already exist!");
        }
        if (userService.hasUserWithEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email already exist!");
        }

        Users users = userService.saveUser(userService.createUser(request));
        return new AuthenticationResponse(users.getId(), users.getName(), users.getRole());
    }


}
