package com.practise.poker.app;

public class InvalidHandException extends RuntimeException{

    public InvalidHandException(String message) {
        super(message);
    }
}
