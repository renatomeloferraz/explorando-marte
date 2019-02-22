package com.nasa.exception;

public class OutOfAreaException extends Exception {
    public OutOfAreaException() {
        super("Rover is outside the area parameters");
    }
}
