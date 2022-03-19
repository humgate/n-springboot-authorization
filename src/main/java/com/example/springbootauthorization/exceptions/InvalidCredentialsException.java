package com.example.springbootauthorization.exceptions;

/**
 * Thrown when password is incorrect
 */
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
