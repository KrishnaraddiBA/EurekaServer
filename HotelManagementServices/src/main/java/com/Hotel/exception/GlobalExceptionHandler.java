package com.Hotel.exception;

import com.Hotel.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> hanndleResourceException(ResourceNotFoundException exception, WebRequest webRequest){
    ApiResponse apiResponse=new ApiResponse();
    apiResponse.setDate(new Date());
    apiResponse.setMesage(exception.getMessage());
    apiResponse.setStatus(HttpStatus.valueOf(webRequest.getDescription(false)));

    return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception exception,WebRequest webRequest){
    ApiResponse apiResponse=new ApiResponse();
    apiResponse.setDate(new Date());
    apiResponse.setMesage(exception.getMessage());
    apiResponse.setStatus(HttpStatus.valueOf(webRequest.getDescription(false)));

return new ResponseEntity<>(
        apiResponse,HttpStatus.NOT_FOUND
);
}

}
