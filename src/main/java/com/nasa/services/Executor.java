package com.nasa.services;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.domain.Rover;
import com.nasa.domain.StateEventListener;
import com.nasa.exception.OutOfAreaException;

import java.util.ArrayList;
import java.util.List;

public class Executor implements StateEventListener {
    List<Rover> run(Area area, Command command) throws OutOfAreaException {
        Rover rover = command.getRover(area);

        for(String movement : command.getMovements()) {
            switch (movement) {
                case "M":
                    move(rover);
                    break;
                case "R":
                    turnRight(rover);
                    break;
                case "L":
                    turnLeft(rover);
                    break;
            }
        }

        return new ArrayList<>();
    }

    public void move(Rover rover) throws OutOfAreaException {
        rover.getState().move(rover);
    }

    public void turnRight(Rover rover) {
        rover.getState().turnRight(rover);
    }

    public void turnLeft(Rover rover) {
        rover.getState().turnLeft(rover);
    }
}
