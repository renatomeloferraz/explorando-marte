package com.nasa.factories;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.domain.State;
import com.nasa.exception.InvalidSequenceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CommandsFactoryTest {

    private CommandsFactory factory;

    private Area area;

    @Before
    public void setUp() {
        factory = new CommandsFactory();
        area = mock(Area.class);
    }

    @Test
    public void createsCommandAccordingArguments() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
        assertEquals(2, commands.size());
    }

    @Test
    public void informsPositionXInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(1, command.getX());
    }

    @Test
    public void informsPositionYInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(2, command.getY());
    }

    @Test
    public void informsNorthStateInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(State.N, command.getState());
    }

    @Test
    public void informsEastStateInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 E LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(State.E, command.getState());
    }

    @Test
    public void informsSouthStateInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 S LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(State.S, command.getState());
    }

    @Test
    public void informsWestStateInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 W LMLMLMLMM");
        Command command = commands.get(0);
        assertEquals(State.W, command.getState());
    }

    @Test
    public void informsMovementsInCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM");
        Command command = commands.get(0);

        String[] expected = {"L","M","L","M","L","M","L","M","M"};
        assertArrayEquals(expected, command.getMovements() );
    }

    @Test
    public void informsListOfCommands() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
        assertEquals(2, commands.size());
    }

    @Test
    public void ignoreInvalidCommand() throws InvalidSequenceException {
        List<Command> commands = factory.create(area, "5 5 1 2 N LMLMLMLMM 3 E MMRMMM");
        assertEquals(1, commands.size());
    }
}