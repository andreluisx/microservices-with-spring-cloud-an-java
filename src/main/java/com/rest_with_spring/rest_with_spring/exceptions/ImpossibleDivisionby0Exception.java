package com.rest_with_spring.rest_with_spring.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ImpossibleDivisionby0Exception extends RuntimeException {
    public ImpossibleDivisionby0Exception(String message) {
        super(message);
    }
}
