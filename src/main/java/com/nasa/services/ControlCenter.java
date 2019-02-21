package com.nasa.services;

import com.nasa.exception.InvalidSequenceException;
import com.nasa.factories.AreaFactory;
import com.nasa.factories.CommandsFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlCenter {

    private final AreaFactory areaFactory;
    private final CommandsFactory commandsFactory;

    public ControlCenter(AreaFactory areaFactory, CommandsFactory commandsFactory) {
        this.areaFactory = areaFactory;
        this.commandsFactory = commandsFactory;
    }

    public void execute(String sequence) throws InvalidSequenceException {
        if(isValid(sequence)) {
            areaFactory.create(sequence);
            commandsFactory.create(sequence);
        }
    }

    private boolean isValid(String sequence) throws InvalidSequenceException {
        Pattern pattern = Pattern.compile(AreaFactory.AREA_REGEX + "\\s" + CommandsFactory.COMMAND_REGEX);
        Matcher matcher = pattern.matcher(sequence);

        if(matcher.find()) {
            return true;
        } else {
            throw new InvalidSequenceException();
        }
    }
}
