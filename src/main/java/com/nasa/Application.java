package com.nasa;

import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import com.nasa.services.CommandCenter;
import com.nasa.services.Executor;

import java.util.Arrays;

public class Application {

    public static void main(String[] sequence) {
        CommandCenter commandCenter = new CommandCenter(
                new AreaFactory(),
                new CommandsFactory(),
                new Executor());

        try {
            commandCenter.execute(Arrays.toString(sequence));
        } catch (InvalidSequenceException | OutOfAreaException e) {
            System.out.println(e.getMessage());
        }
    }
}
