package com.bananaapps.bananamusic.config;

import com.bananaapps.bananamusic.exception.SongNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SongNotfoundException.class)
    ResponseEntity songNotfoundExceptionHandler (SongNotfoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song not found");
    }

}
