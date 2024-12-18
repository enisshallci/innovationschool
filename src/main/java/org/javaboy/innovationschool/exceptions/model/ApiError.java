package org.javaboy.innovationschool.exceptions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private List<String> errors;

    //Qysh me kthy tek klienti.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ApiError(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String error) {
        this.status = status;
        this.errors = Collections.singletonList(error);
        this.timestamp = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
