package com.apigateway.appengine.exception;

public class InvalidInputException extends  RuntimeException{

    public InvalidInputException(String message) {
        super(message);
    }
}
