package com.fullstack.advice;

import com.fullstack.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalCustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleCustomException(RecordNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleCustomValidation(MethodArgumentNotValidException exception){

        Map<String, String> errorMap = new LinkedHashMap<>();

        exception.getBindingResult().getAllErrors().forEach(objectError -> {
            String field = ((FieldError) objectError).getField();

            String errorMessage = objectError.getDefaultMessage();

            errorMap.put(field, errorMessage);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}
