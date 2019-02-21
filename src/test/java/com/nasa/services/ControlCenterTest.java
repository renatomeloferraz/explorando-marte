package com.nasa.services;

import com.nasa.exception.InvalidCommandException;
import com.nasa.factories.AreaFactory;
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

    private ControlCenter control;

    @Before
    public void setUp() {
        control = new ControlCenter(areaFactory);
    }

    @Test
    public void callAreaFactoryIfCommandIsValid() throws InvalidCommandException {
        String commands = "5 5 1 2 N LMLMLMLMM";
        control.execute(commands);
        verify(areaFactory).create(commands);
    }

    @Test(expected = InvalidCommandException.class)
    public void throwsExceptionIfCommandDoesNotHaveArea() throws InvalidCommandException {
        control.execute("1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }

    @Test(expected = InvalidCommandException.class)
    public void throwsExceptionIfCommandAreaIsIncomplete() throws InvalidCommandException {
        control.execute("5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }
}