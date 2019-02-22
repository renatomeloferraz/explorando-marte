package com.nasa.rest.controllers;

import com.nasa.rest.builders.RoverBuilder;
import com.nasa.rest.requests.RoverRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoversControllerTest {

    @Mock
    private RoverRequest request;

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