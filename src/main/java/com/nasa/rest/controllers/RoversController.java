package com.nasa.rest.controllers;

import com.nasa.rest.builders.RoverBuilder;
import com.nasa.rest.domains.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoversController {

    @Autowired
    private RoverBuilder builder;

    @PostMapping("/rovers")
    public Rover create(@RequestBody Rover request) {
        return builder.create(request);
    }
}