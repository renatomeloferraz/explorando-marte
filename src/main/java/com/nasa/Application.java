package com.nasa;

import com.nasa.exception.InvalidCommandException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import com.nasa.services.ControlCenter;

import java.util.Arrays;

public class Application {

    public static void main(String[] commands) {
        ControlCenter controlCenter = new ControlCenter(new AreaFactory(), new CommandsFactory());

        try {
            controlCenter.execute(Arrays.toString(commands));
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
