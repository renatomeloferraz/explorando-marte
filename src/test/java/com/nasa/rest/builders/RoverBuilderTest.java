package com.nasa.rest.builders;

import com.nasa.rest.domains.Rover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoverBuilderTest {

    @Mock
    private Rover rover;

    private RoverBuilder builder;

    @Before
    public void setUp() {
        builder = new RoverBuilder();
    }

    @Test
    public void createOneRover() {
        builder.create(rover);
        assertEquals(1, builder.getRovers().size());
    }

    @Test
    public void createTwoRover() {
        when(rover.getId())
                .thenReturn("1")
                .thenReturn("2");

        builder.create(rover);
        builder.create(rover);

        assertEquals(2, builder.getRovers().size());
    }
}