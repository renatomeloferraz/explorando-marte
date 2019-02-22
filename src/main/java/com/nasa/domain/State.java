package com.nasa.domain;

import com.nasa.exception.OutOfAreaException;

public enum State implements StateEventListener {

    N {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToNorth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(W);
        }

        public void turnRight(Rover rover) {
            rover.setState(E);
        }
    },
    E {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToEast();
        }

        public void turnLeft(Rover rover) {
            rover.setState(N);
        }

        public void turnRight(Rover rover) {
            rover.setState(S);
        }
    },
    S {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToSouth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(E);
        }

        public void turnRight(Rover rover) {
            rover.setState(W);
        }
    },
    W {
        public void move(Rover rover) throws OutOfAreaException {
            rover.movesToWest();
        }

        public void turnLeft(Rover robot) {
            robot.setState(S);
        }

        public void turnRight(Rover robot) {
            robot.setState(N);
        }
    }
}
