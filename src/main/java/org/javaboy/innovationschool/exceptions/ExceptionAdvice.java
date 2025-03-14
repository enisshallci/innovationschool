package org.javaboy.innovationschool.exceptions;

import org.javaboy.innovationschool.exceptions.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    //Krejt exceptions qe kalojne kah controllers te serverit ton, kane me ardhë ne kete klase.

    @ExceptionHandler(CustomNotFoundException.class)
    ApiError handleCustomNotFoundException(CustomNotFoundException ex) {

        return new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}




/*
    Spring boot na mundeson qe nje klase "Centralizim te handling te errorave/exceptions".
    Me bo nje klase qe krejt exceptions vine ne kete klase (kalojne) dhe shkojne dikun tjeter.
 */