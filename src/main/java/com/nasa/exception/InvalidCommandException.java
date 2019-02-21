package com.nasa.exception;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("The command sent is invalid");
    }
}
