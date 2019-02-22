package com.nasa.rest.domains;

import java.util.UUID;

public class Rover {

    private final String id;

    private Area area;
    private Integer x;
    private Integer y;
    private String direction;

    public Rover() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
