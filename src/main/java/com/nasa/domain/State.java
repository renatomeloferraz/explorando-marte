package com.nasa.domain;

public enum State implements StateEventListener {

    NORTH {
        public void move(Rover rover) {
            rover.moveToNorth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(WEST);
        }

        public void turnRight(Rover rover) {
            rover.setState(EAST);
        }
    },
    SOUTH {
        public void move(Rover rover) {
            rover.moveToSouth();
        }

        public void turnLeft(Rover rover) {
            rover.setState(EAST);
        }

        public void turnRight(Rover rover) {
            rover.setState(WEST);
        }
    },
    EAST {
        public void move(Rover rover) {
            rover.moveToEast();
        }

        public void turnLeft(Rover rover) {
            rover.setState(NORTH);
        }

        public void turnRight(Rover rover) {
            rover.setState(SOUTH);
        }
    },
    WEST {
        public void move(Rover rover) {
            rover.moveToWest();
        }

        public void turnLeft(Rover robot) {
            robot.setState(SOUTH);
        }

        public void turnRight(Rover robot) {
            robot.setState(NORTH);
        }
    }
}
