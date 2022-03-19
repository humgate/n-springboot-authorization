package com.example.springbootauthorization.exceptions;

/**
 * Thrown when user does not have any authorities
 */
public class UnauthorizedUserException extends RuntimeException {
    public UnauthorizedUserException(String msg) {
        super(msg);
    }
}
