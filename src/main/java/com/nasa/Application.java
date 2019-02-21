package com.nasa;

import com.nasa.exception.InvalidSequenceException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import com.nasa.services.ControlCenter;

import java.util.Arrays;

public class Application {

    public static void main(String[] sequence) {
        ControlCenter controlCenter = new ControlCenter(new AreaFactory(), new CommandsFactory());

        try {
            controlCenter.execute(Arrays.toString(sequence));
        } catch (InvalidSequenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
