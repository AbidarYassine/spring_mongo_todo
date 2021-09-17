package com.fstg.spring_mongoo.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public static String notFoundException(String id) {
        return "Todo with name " + id + " not found";
    }

}
