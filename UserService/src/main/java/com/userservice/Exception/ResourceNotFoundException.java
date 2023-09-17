package com.userservice.Exception;

public class ResourceNotFoundException extends RuntimeException {

    private String msg;

    public ResourceNotFoundException(String msg) {

        super(String.format("%s not found!!!", msg));
        this.msg = msg;
    }
    public ResourceNotFoundException(){
        super("No Resource Found in exiting id");
    }
}



