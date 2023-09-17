package com.Hotel.exception;

public class ResourceNotFoundException extends RuntimeException{

     String message;

    public ResourceNotFoundException(String message){
        this.message=message;
    }
    ResourceNotFoundException(){
        super("given id ResourceNot found !!!");
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
