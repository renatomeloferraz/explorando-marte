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
        State.N.move(rover);
        verify(rover).movesToNorth();
    }

    @Test
    public void turnRoverInNorthToLeft() {
        State.N.turnLeft(rover);
        verify(rover).setState(W);
    }

    @Test
    public void turnRoverInNorthToRight() {
        State.N.turnRight(rover);
        verify(rover).setState(E);
    }

    @Test
    public void movesRoverToSouth() throws OutOfAreaException {
        State.S.move(rover);
        verify(rover).movesToSouth();
    }

    @Test
    public void turnRoverInSouthToLeft() {
        State.S.turnLeft(rover);
        verify(rover).setState(E);
    }

    @Test
    public void turnRoverInSouthToRight() {
        State.S.turnRight(rover);
        verify(rover).setState(W);
    }

    @Test
    public void movesRoverToEast() throws OutOfAreaException {
        State.E.move(rover);
        verify(rover).movesToEast();
    }

    @Test
    public void turnRoverInEastToLeft() {
        State.E.turnLeft(rover);
        verify(rover).setState(N);
    }

    @Test
    public void turnRoverInEastToRight() {
        State.E.turnRight(rover);
        verify(rover).setState(S);
    }

    @Test
    public void movesRoverToWest() throws OutOfAreaException {
        State.W.move(rover);
        verify(rover).movesToWest();
    }

    @Test
    public void turnRoverInWestToLeft() {
        State.W.turnLeft(rover);
        verify(rover).setState(S);
    }

    @Test
    public void turnRoverInWestToRight() {
        State.W.turnRight(rover);
        verify(rover).setState(N);
    }
}