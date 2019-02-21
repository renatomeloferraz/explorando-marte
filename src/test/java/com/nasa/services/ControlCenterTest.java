package com.nasa.services;

import com.nasa.exception.InvalidSequenceException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ControlCenterTest {

    @Mock
    private AreaFactory areaFactory;

    @Mock
    private CommandsFactory commandsFactory;

    private ControlCenter control;

    @Before
    public void setUp() {
        control = new ControlCenter(areaFactory, commandsFactory);
    }

    @Test
    public void callAreaFactoryIfSequenceIsValid() throws InvalidSequenceException {
        String sequence = "5 5 1 2 N LMLMLMLMM";
        control.execute(sequence);
        verify(areaFactory).create(sequence);
    }

    @Test
    public void callCommandsFactoryIfSequenceIsValid() throws InvalidSequenceException {
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