package com.nasa.rest.controllers;

import com.nasa.rest.builders.RoverBuilder;
import com.nasa.rest.domains.Rover;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoversControllerTest {

    @Mock
    private Rover request;

    @Mock
    private RoverBuilder builder;

    @InjectMocks
    private RoversController controller;

    @Test
    public void callsRoverBuilderToCreateRover() {
        controller.create(request);
        verify(builder).create(request);
    }
}