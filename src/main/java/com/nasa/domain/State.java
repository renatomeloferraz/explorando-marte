package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;

public enum State implements StateEventListener {

    NORTH {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToNorth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(WEST);
        }

        public void turnRight(Rover rover) {
            rover.setState(EAST);
        }
    },
    SOUTH {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToSouth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(EAST);
        }

        public void turnRight(Rover rover) {
            rover.setState(WEST);
        }
    },
    EAST {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToEast();
        }

        public void turnLeft(Rover rover) {
            rover.setState(NORTH);
        }

        public void turnRight(Rover rover) {
            rover.setState(SOUTH);
        }
    },
    WEST {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToWest();
        }

        public void turnLeft(Rover robot) {
            robot.setState(SOUTH);
        }

        public void turnRight(Rover robot) {
            robot.setState(NORTH);
        }
    }
}
