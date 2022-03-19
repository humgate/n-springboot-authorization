package com.example.springbootauthorization.controller;

import com.example.springbootauthorization.enums.Authorities;
import com.example.springbootauthorization.exceptions.InvalidCredentialsException;
import com.example.springbootauthorization.exceptions.NoSuchUserException;
import com.example.springbootauthorization.exceptions.UnauthorizedUserException;
import com.example.springbootauthorization.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    AuthorizationController (AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUserException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NoSuchUserException.class)
    ResponseEntity<String> handleNoSuchUser(NoSuchUserException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
