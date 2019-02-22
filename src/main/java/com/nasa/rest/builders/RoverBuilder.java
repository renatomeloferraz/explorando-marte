package com.nasa.rest.builders;

import com.nasa.rest.domains.Rover;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RoverBuilder {

    private Map<String, Rover> rovers = new HashMap<>();

    public Rover create(Rover rover) {
        rovers.put(rover.getId(), rover);
        return rover;
    }

    public Map<String, Rover> getRovers() {
        return rovers;
    }
}
