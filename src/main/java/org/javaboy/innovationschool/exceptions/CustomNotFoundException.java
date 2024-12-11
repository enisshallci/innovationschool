package org.javaboy.innovationschool.exceptions;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException() {
        super("Not found!");
    }

    public CustomNotFoundException(String message) {
        super(message);
    }
}

