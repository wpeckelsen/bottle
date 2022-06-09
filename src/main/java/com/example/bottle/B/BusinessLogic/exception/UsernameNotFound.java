package com.example.bottle.B.BusinessLogic.exception;

public class UsernameNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFound(String username) {
        super("Cannot find user " + username);
    }

}