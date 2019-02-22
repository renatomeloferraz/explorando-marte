package com.nasa.services;

import com.nasa.domain.Command;
import com.nasa.domain.Rover;
import com.nasa.domain.StateEventListener;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;

public class Executor implements StateEventListener {
    Rover run(Command command) throws OutOfAreaException, InvalidSequenceException {
        Rover rover = command.getRover();

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
                default:
                    throw new InvalidSequenceException();
            }
        }

        return rover;
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
