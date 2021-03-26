package com.myhouse.socialnetwork.services.exception;

public class ObjectNotFoundException extends RuntimeException{

    private final static long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
