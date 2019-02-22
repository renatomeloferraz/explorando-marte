package com.nasa.domain;

public class Command {
    private final int x;
    private final int y;
    private final String direction;
    private final String[] movements;

    public Command(int x, int y, String direction, String movements) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.movements = movements.split("");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public String[] getMovements() {
        return movements;
    }
}
