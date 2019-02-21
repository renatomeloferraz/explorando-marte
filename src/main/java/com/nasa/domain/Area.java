package com.nasa.domain;

public class Area {

    private final int top;
    private final int right;
    private final int bottom;
    private final int left;

    public Area(int top, int right) {
        this.top = top;
        this.right = right;
        left = 0;
        bottom = 0;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }
}
