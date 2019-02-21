package com.nasa.factories;

import com.nasa.domain.Area;
import com.nasa.exception.InvalidSequenceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaFactoryTest {

    private Area area;

    @Before
    public void setUp() throws InvalidSequenceException {
        AreaFactory factory = new AreaFactory();
        area = factory.create("5 5 1 2 N LMLMLMLMM");
    }

    @Test
    public void informsTop() {
        assertEquals(5, area.getTop());
    }

    @Test
    public void informsRight() {
        assertEquals(5, area.getRight());
    }

    @Test
    public void informsBottom() {
        assertEquals(0, area.getBottom());
    }

    @Test
    public void informsLeft() {
        assertEquals(0, area.getLeft());
    }
}