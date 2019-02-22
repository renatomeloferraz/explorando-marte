package com.nasa.services;

import com.nasa.domain.Command;
import com.nasa.domain.Rover;
import com.nasa.domain.StateEventListener;

public class Executor implements StateEventListener {
    void run(Command command) {
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
            }
        }
    }

    public void move(Rover rover) {
        rover.getState().move(rover);
    }

    public void turnRight(Rover rover) {
        rover.getState().turnRight(rover);
    }

    public void turnLeft(Rover rover) {
        rover.getState().turnLeft(rover);
    }
}
