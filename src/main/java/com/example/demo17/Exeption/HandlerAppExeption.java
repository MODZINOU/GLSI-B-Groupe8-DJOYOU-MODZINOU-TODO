package com.example.demo17.Exeption;

import com.example.demo17.Shared.ErrorMessage;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@ControllerAdvice
public class HandlerAppExeption {

    @ExceptionHandler(value = {EntityNotFoundExeption.class})
    public ResponseEntity<Object> entityNotFoundExeption(EntityNotFoundExeption ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = {EntityAllreadyExistExeption.class})
    public ResponseEntity<Object> entityAllReadyExist(EntityAllreadyExistExeption ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .code(409)
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);

    }
}
