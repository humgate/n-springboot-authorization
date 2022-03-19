package com.example.springbootauthorization.exceptions;

/**
 * Thrown when user not found
 */
public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(String msg) {
        super(msg);
    }
}
