package com.nasa.exception;

public class InvalidSequenceException extends Exception {
    public InvalidSequenceException() {
        super("The sequence sent is not valid");
    }
}
