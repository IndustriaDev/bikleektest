package com.example.bikleektest.errors;

public class ResourceNotFoundException extends RuntimeException {

    ResourceNotFoundException(String message){
        super(message);
    }
}
