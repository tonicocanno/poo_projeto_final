package com.example.poo_projeto_final.controller.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class MyHandleExceptions {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            
            String field =  ((FieldError) error).getField();
            String code  =  ((FieldError) error).getCode();
            String msg   =   error.getDefaultMessage();

            errors.put(field +":"+code, msg);
            
        });
        
        return errors;
    }

    
}

