package com.nasa.domain;

public class Rover {
    private int x = 0;
    private int y = 0;
    private State state = State.NORTH;

    public Rover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void moveToNorth() {

    }

    public void moveToSouth() {

    }

    public void moveToEast() {

    }

    public void moveToWest() {

    }
}
