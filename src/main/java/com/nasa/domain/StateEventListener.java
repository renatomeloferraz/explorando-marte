package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;

public interface StateEventListener {
    void move(Rover rover) throws OutOfAreaException;
    void turnLeft(Rover rover);
    void turnRight(Rover rover);
}
