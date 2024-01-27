package com.genisyscoding.springJpa.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalid(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult()
                .getAllErrors()
                .forEach(ex -> errorMap.put(ex.getObjectName(), ex.getDefaultMessage()));

        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public Map<String, String> handleUserNotFound(UserPrincipalNotFoundException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(exception.getName(), exception.getMessage());
        return errorMap;
    }
}
