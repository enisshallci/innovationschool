package org.javaboy.innovationschool.exceptions;

public class CustomNotFoundException extends RuntimeException { //Shumicen e rasteve na vyn custom me qene RuntimeException

    public CustomNotFoundException() {
        super("Not found!");
    }

    public CustomNotFoundException(String message) {
        super(message);
    }
}

