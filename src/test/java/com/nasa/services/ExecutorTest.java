package com.nasa.services;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.domain.Rover;
import com.nasa.domain.State;
import com.nasa.exception.OutOfAreaException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExecutorTest {

    @Mock
    private Command command;

    @Mock
    private Rover rover;

    @Mock
    private State state;

    @Mock
    private Area area;

    private Executor executor;

    @Before
    public void setUp() {
        when(rover.getState()).thenReturn(state);
        when(command.getRover(area)).thenReturn(rover);
        executor = new Executor();
    }

    @Test
    public void movesRover() throws OutOfAreaException {
        when(command.getMovements()).thenReturn(new String[] { "M" });
        executor.run(area, command);
        verify(state).move(rover);
    }

    @Test
    public void turnRover() throws OutOfAreaException {
        when(command.getMovements()).thenReturn(new String[] { "L", "R" });
        executor.run(area, command);

        InOrder orderVerifier = Mockito.inOrder(state);

        orderVerifier.verify(state).turnLeft(rover);
        orderVerifier.verify(state).turnRight(rover);
    }
}