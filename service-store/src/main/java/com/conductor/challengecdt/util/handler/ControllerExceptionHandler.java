package com.conductor.challengecdt.util.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseError handleNotFoundExceptions(ObjectNotFoundException ex) {

        ResponseError responseError = new ResponseError();
        responseError.setCode(HttpStatus.NOT_FOUND.value());
        responseError.setDescription("Resource not found.");

        log.error(ex.getMessage(), ex);

        return responseError;
    }
}
