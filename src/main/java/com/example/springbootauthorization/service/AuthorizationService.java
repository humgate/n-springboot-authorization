package com.example.springbootauthorization.service;

import com.example.springbootauthorization.enums.Authorities;
import com.example.springbootauthorization.exceptions.InvalidCredentialsException;
import com.example.springbootauthorization.exceptions.NoSuchUserException;
import com.example.springbootauthorization.exceptions.UnauthorizedUserException;
import com.example.springbootauthorization.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    AuthorizationService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        // invalid user name
        if (isEmpty(user)) {
            throw new NoSuchUserException("Invalid user name");
        }

        // empty password
        if (isEmpty(password)) {
            throw new InvalidCredentialsException("Password is empty");
        }

        // user not found
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (userAuthorities == null) {
            throw new NoSuchUserException("User does not exits: " + user);
        }

        // user unauthorized
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUserException("Unauthorized user or password incorrect: " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
