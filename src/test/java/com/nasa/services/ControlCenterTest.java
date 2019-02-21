package com.nasa.services;

import com.nasa.exception.InvalidCommandException;
import org.junit.Before;
import org.junit.Test;

public class ControlCenterTest {

    private ControlCenter control;

    @Before
    public void setUp() {
        control = new ControlCenter();
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