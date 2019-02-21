package com.nasa.factories;

import com.nasa.domain.Command;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommandsFactoryTest {

    private CommandsFactory factory;

    @Before
    public void setUp() {
        factory = new CommandsFactory();
    }

    @Test
    public void createsCommandAccordingArguments() {
        List<Command> commands = factory.create("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");

        Command command = commands.get(0);
        assertEquals(1, command.getX());
        assertEquals(2, command.getY());
        assertEquals("N", command.getDirection());
        assertEquals("LMLMLMLMM", command.getMovements());
    }

    @Test
    public void informsListOfCommands() {
        List<Command> commands = factory.create("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
        assertEquals(2, commands.size());
    }

    @Test
    public void ignoreInvalidCommand() {
        List<Command> commands = factory.create("5 5 1 2 N LMLMLMLMM 3 E MMRMMM");
        assertEquals(1, commands.size());
    }
}