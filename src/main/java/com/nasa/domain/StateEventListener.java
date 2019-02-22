package com.nasa.domain;

public interface StateEventListener {
    void move(Rover rover);
    void turnLeft(Rover rover);
    void turnRight(Rover rover);
}
