package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;

public class Rover {

    private final Area area;

    private int x;
    private int y;
    private State state;

    Rover(Area area, int x, int y, State state) {
        this.area = area;
        this.x = x;
        this.y = y;
        this.state = state;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }

    void movesToNorth() throws OutOfAreaException {
        this.y++;
        if (y > area.getTop()) {
            throw new OutOfAreaException();
        }
    }

    void movesToSouth() throws OutOfAreaException {
        this.y--;
        if (y < area.getBottom()) {
            throw new OutOfAreaException();
        }
    }

    void movesToEast() throws OutOfAreaException {
        this.x++;
        if (x > area.getRight()) {
            throw new OutOfAreaException();
        }
    }

    void movesToWest() throws OutOfAreaException {
        this.x--;
        if (x < area.getLeft()) {
            throw new OutOfAreaException();
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + state;
    }
}
