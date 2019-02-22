package com.nasa.domain;

public class Command {
    private final int x;
    private final int y;
    private final State state;
    private final String[] movements;
    private final Area area;

    public Command(int x, int y, State state, String[] movements, Area area) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.movements = movements;
        this.area = area;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public String[] getMovements() {
        return movements;
    }

    public Rover getRover() {
        return new Rover(area, x, y, state);
    }
}
