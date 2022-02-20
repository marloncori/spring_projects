package com.jguides.student.registration.exception;

import com.jguides.student.registration.model.ErrorMessage;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundException (StudentNotFoundException exception,
                                                                  WebRequest request){
        val errMsg = new ErrorMessage(NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(NOT_FOUND)
                .body(errMsg);
    }

    @ExceptionHandler(StudentAlreadySavedException.class)
    public  ResponseEntity<ErrorMessage> studentAlreadySavedException (StudentAlreadySavedException error,
                                                                       WebRequest req){
        val errMsg2 = new ErrorMessage(ALREADY_REPORTED, error.getMessage());
        return ResponseEntity.status(ALREADY_REPORTED)
                .body(errMsg2);
    }
}
