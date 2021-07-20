package com.pala.memsource.memsource.exception;

/**
 * Throwed when user with incoming username already exists
 */
public class UsernameAlreadyExistsException extends Exception {
    
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }

}
