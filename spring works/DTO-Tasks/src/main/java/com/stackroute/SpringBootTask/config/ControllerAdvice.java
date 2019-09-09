package com.stackroute.SpringBootTask.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<String> exceptionHandler(Exception e) {
    return new ResponseEntity<>("Error thrown globally : " + e.getMessage(), HttpStatus.CONFLICT);
  }
}
