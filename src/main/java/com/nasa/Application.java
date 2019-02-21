package com.nasa;

import com.nasa.exception.InvalidCommandException;
import com.nasa.services.ControlCenter;

import java.util.Arrays;

public class Application {

    public static void main(String[] commands) {
        try {
            new ControlCenter().execute(Arrays.toString(commands));
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
