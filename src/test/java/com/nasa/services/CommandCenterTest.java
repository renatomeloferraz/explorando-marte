package com.nasa.services;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;
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

    @Mock
    private Area area;

    private CommandCenter control;

    @Before
    public void setUp() throws InvalidSequenceException {
        when(areaFactory.create(anyString())).thenReturn(area);
        control = new CommandCenter(areaFactory, commandsFactory, executor);
    }

    @Test
    public void callsAreaFactoryIfSequenceIsValid() throws Exception {
        String sequence = "5 5 1 2 N LMLMLMLMM";
        control.execute(sequence);
        verify(areaFactory).create(sequence);
    }

    @Test
    public void callsExecutorAccordingNumberCommands() throws Exception {
        String sequence = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        when(commandsFactory.create(sequence)).thenReturn(Arrays.asList(mock(Command.class), mock(Command.class)));
        control.execute(sequence);
        verify(executor, times(2)).run(eq(area), any(Command.class));
    }

    @Test
    public void callsCommandsFactoryIfSequenceIsValid() throws Exception {
        String Sequence = "5 5 1 2 N LMLMLMLMM";
        control.execute(Sequence);
        verify(commandsFactory).create(Sequence);
    }

    @Test(expected = InvalidSequenceException.class)
    public void throwsExceptionIfSequenceDoesNotHaveArea() throws Exception {
        control.execute("1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }

    @Test(expected = InvalidSequenceException.class)
    public void throwsExceptionIfSequenceAreaIsIncomplete() throws Exception {
        control.execute("5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }

    @Test(expected = InvalidSequenceException.class)
    public void throwsExceptionAreaFactorythrowException() throws Exception {
        String sequence = "5 5 1 2 N LMLMLMLMM";
        when(areaFactory.create(sequence)).thenThrow(InvalidSequenceException.class);
        control.execute(sequence);
    }

    @Test(expected = OutOfAreaException.class)
    public void throwsExceptionAreaFactorythrowException2() throws Exception {
        String sequence = "5 5 1 2 N LMLMLMLMM";
        when(commandsFactory.create(sequence)).thenReturn(Arrays.asList(mock(Command.class), mock(Command.class)));
        when(executor.run(eq(area), any(Command.class))).thenThrow(OutOfAreaException.class);
        control.execute(sequence);
    }
}