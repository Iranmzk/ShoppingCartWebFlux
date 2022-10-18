package com.example.exceptions;

public class ApiNotFoundException extends RuntimeException{
    public ApiNotFoundException(String message){
        super(message);
    }
}
