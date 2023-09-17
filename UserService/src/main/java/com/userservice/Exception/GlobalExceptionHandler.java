package com.userservice.Exception;

import com.userservice.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webrequest){

    ErrorDetails er=new ErrorDetails(new Date(),exception.getMessage(),webrequest.getDescription(false));
    return new ResponseEntity<>(er, HttpStatus.OK);
}
@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webrequest){
    ErrorDetails er2=new ErrorDetails(new Date(),exception.getMessage(),webrequest.getDescription(false));
    return new ResponseEntity<>(er2,HttpStatus.OK);
}


}
