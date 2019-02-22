package com.nasa;

import com.nasa.domain.Rover;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import com.nasa.services.CommandCenter;
import com.nasa.services.Executor;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] sequence) {
        CommandCenter commandCenter = new CommandCenter(
                new AreaFactory(),
                new CommandsFactory(),
                new Executor());

        try {
            ArrayList<Rover> rovers = commandCenter.execute(parserSequence(sequence));
            print(rovers);

        } catch (InvalidSequenceException | OutOfAreaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void print(ArrayList<Rover> rovers) {
        for(Rover rover : rovers) {
            System.out.println(rover.toString());
        }
    }

    private static String parserSequence(String[] sequence) {
        String sequences = Arrays.toString(sequence);
        return sequences.substring(1, sequences.length() - 1)
                .replace(",", "");
    }
}
