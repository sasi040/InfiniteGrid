package com.gomspace.infiniteGrid.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MachineControllerAdvice {

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity handleApplicationException(final ApplicationException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
