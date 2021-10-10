package com.tdd.demo;

public class InvalidPositionException extends RuntimeException{
    public InvalidPositionException() {
        super("Invalid Position");
    }
}
