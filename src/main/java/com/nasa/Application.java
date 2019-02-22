package com.nasa;

import com.nasa.domain.Rover;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;
import com.nasa.services.CommandCenter;
import com.nasa.services.Executor;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class Application {

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
        logger = Logger.getLogger(Application.class.getName());
    }

    public static void main(String[] sequence) {
        CommandCenter commandCenter = new CommandCenter(
                new AreaFactory(),
                new CommandsFactory(),
                new Executor());

        try {
            List<Rover> rovers = commandCenter.execute(parserSequence(sequence));
            print(rovers);

        } catch (InvalidSequenceException | OutOfAreaException e) {
            logger.warning(e.getMessage());
        }
    }

    private static void print(List<Rover> rovers) {
        for(Rover rover : rovers) {
            String result = rover.toString();
            logger.info(result);
        }
    }

    private static String parserSequence(String[] sequence) {
        String sequences = Arrays.toString(sequence);
        return sequences.substring(1, sequences.length() - 1)
                .replace(",", "");
    }
}
