package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.nasa.domain.State.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StateTest {

    @Mock
    Rover rover;

    @Test
    public void movesRoverToNorth() throws OutOfAreaException {
        State.NORTH.move(rover);
        verify(rover).movesToNorth();
    }

    @Test
    public void turnRoverInNorthToLeft() {
        State.NORTH.turnLeft(rover);
        verify(rover).setState(WEST);
    }

    @Test
    public void turnRoverInNorthToRight() {
        State.NORTH.turnRight(rover);
        verify(rover).setState(EAST);
    }

    @Test
    public void movesRoverToSouth() throws OutOfAreaException {
        State.SOUTH.move(rover);
        verify(rover).movesToSouth();
    }

    @Test
    public void turnRoverInSouthToLeft() {
        State.SOUTH.turnLeft(rover);
        verify(rover).setState(EAST);
    }

    @Test
    public void turnRoverInSouthToRight() {
        State.SOUTH.turnRight(rover);
        verify(rover).setState(WEST);
    }

    @Test
    public void movesRoverToEast() throws OutOfAreaException {
        State.EAST.move(rover);
        verify(rover).movesToEast();
    }

    @Test
    public void turnRoverInEastToLeft() {
        State.EAST.turnLeft(rover);
        verify(rover).setState(NORTH);
    }

    @Test
    public void turnRoverInEastToRight() {
        State.EAST.turnRight(rover);
        verify(rover).setState(SOUTH);
    }

    @Test
    public void movesRoverToWest() throws OutOfAreaException {
        State.WEST.move(rover);
        verify(rover).movesToWest();
    }

    @Test
    public void turnRoverInWestToLeft() {
        State.WEST.turnLeft(rover);
        verify(rover).setState(SOUTH);
    }

    @Test
    public void turnRoverInWestToRight() {
        State.WEST.turnRight(rover);
        verify(rover).setState(NORTH);
    }
}