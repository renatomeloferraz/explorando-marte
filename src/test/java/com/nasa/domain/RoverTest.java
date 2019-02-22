package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    private Area area;

    @Before
    public void setUp() {
       area = new Area(5, 5);
    }

    @Test
    public void movesToNorth() throws OutOfAreaException {
        Rover rover = new Rover(area, 0, 2);
        rover.movesToNorth();
        assertEquals(3, rover.getY());
    }

    @Test(expected = OutOfAreaException.class)
    public void triesToMoveNorthOutOfArea() throws OutOfAreaException {
        Rover rover = new Rover(area, 0, 4);
        rover.movesToNorth();
    }

    @Test
    public void movesToSouth() throws OutOfAreaException {
        Rover rover = new Rover(area, 0, 2);
        rover.movesToSouth();
        assertEquals(1, rover.getY());
    }

    @Test(expected = OutOfAreaException.class)
    public void triesToMoveSouthOutOfArea() throws OutOfAreaException {
        Rover rover = new Rover(area, 0, 1);
        rover.movesToSouth();
    }

    @Test
    public void movesToEast() throws OutOfAreaException {
        Rover rover = new Rover(area, 2, 0);
        rover.movesToEast();
        assertEquals(3, rover.getX());
    }

    @Test(expected = OutOfAreaException.class)
    public void triesToMoveEastOutOfArea() throws OutOfAreaException {
        Rover rover = new Rover(area, 4, 0);
        rover.movesToEast();
    }

    @Test
    public void movesToWest() throws OutOfAreaException {
        Rover rover = new Rover(area, 3, 0);
        rover.movesToWest();
        assertEquals(2, rover.getX());
    }

    @Test(expected = OutOfAreaException.class)
    public void triesToMoveWestOutOfArea() throws OutOfAreaException {
        Rover rover = new Rover(area, 1, 0);
        rover.movesToWest();
    }
}