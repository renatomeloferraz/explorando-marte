package com.nasa.services;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.domain.Rover;
import com.nasa.exception.InvalidSequenceException;
import com.nasa.exception.OutOfAreaException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandCenter {

    private final AreaFactory areaFactory;
    private final CommandsFactory commandsFactory;
    private final Executor executor;

    public CommandCenter(AreaFactory areaFactory, CommandsFactory commandsFactory, Executor executor) {
        this.areaFactory = areaFactory;
        this.commandsFactory = commandsFactory;
        this.executor = executor;
    }

    public List<Rover> execute(String sequence) throws InvalidSequenceException, OutOfAreaException {
        ArrayList<Rover> rovers = new ArrayList<>();

        if(isValid(sequence)) {
            Area area = areaFactory.create(sequence);
            List<Command> commands = commandsFactory.create(area, sequence);

            for(Command command : commands) {
                Rover rover = executor.run(command);
                rovers.add(rover);
            }
        }

        return rovers;
    }

    private Boolean isValid(String sequence) throws InvalidSequenceException {
        Pattern pattern = Pattern.compile(AreaFactory.AREA_REGEX + "\\s" + CommandsFactory.COMMAND_REGEX);
        Matcher matcher = pattern.matcher(sequence);

        if(matcher.find()) {
            return true;
        } else {
            throw new InvalidSequenceException();
        }
    }
}
