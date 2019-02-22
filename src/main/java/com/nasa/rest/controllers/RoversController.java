package com.nasa.rest.controllers;

import com.nasa.rest.builders.RoverBuilder;
import com.nasa.rest.requests.RoverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class RoversController {

    @Autowired
    private RoverBuilder builder;

    @PostMapping("/rovers")
    RoverRequest create(@RequestBody RoverRequest request) {
        return builder.create(request);
    }
}