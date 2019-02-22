package com.nasa.services;

import com.nasa.domain.Command;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CommandCenterTest {

    @Mock
    private AreaFactory areaFactory;

    @Mock
    private CommandsFactory commandsFactory;

    @Mock
    private Executor executor;

    private CommandCenter control;

    @Before
    public void setUp() {
        control = new CommandCenter(areaFactory, commandsFactory, executor);
    }

    @Test
    public void callsAreaFactoryIfSequenceIsValid() throws InvalidSequenceException {
        String sequence = "5 5 1 2 N LMLMLMLMM";
        control.execute(sequence);
        verify(areaFactory).create(sequence);
    }

    @Test
    public void callsExecutorAccordingNumberCommands() throws InvalidSequenceException {
        String sequence = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        when(commandsFactory.create(sequence)).thenReturn(Arrays.asList(mock(Command.class), mock(Command.class)));
        control.execute(sequence);
        verify(executor, times(2)).run(any(Command.class));
    }

    @Test
    public void callsCommandsFactoryIfSequenceIsValid() throws InvalidSequenceException {
        String Sequence = "5 5 1 2 N LMLMLMLMM";
        control.execute(Sequence);
        verify(commandsFactory).create(Sequence);
    }

    @Test(expected = InvalidSequenceException.class)
    public void throwsExceptionIfSequenceDoesNotHaveArea() throws InvalidSequenceException {
        control.execute("1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }

    @Test(expected = InvalidSequenceException.class)
    public void throwsExceptionIfSequenceAreaIsIncomplete() throws InvalidSequenceException {
        control.execute("5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }
}