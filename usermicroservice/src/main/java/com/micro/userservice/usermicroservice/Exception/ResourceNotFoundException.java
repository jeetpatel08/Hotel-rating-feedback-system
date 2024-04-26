package com.micro.userservice.usermicroservice.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("resource not found!");

    }

    public ResourceNotFoundException(String msg) {
        super(msg);

    }

}
