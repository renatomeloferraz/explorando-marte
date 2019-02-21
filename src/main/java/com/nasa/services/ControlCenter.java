package com.nasa.services;

import com.nasa.exception.InvalidCommandException;
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

    public void execute(String commands) throws InvalidCommandException {
        if(isValidCommands(commands)) {
            areaFactory.create(commands);
            commandsFactory.create(commands);
        }
    }

    private boolean isValidCommands(String commands) throws InvalidCommandException {
        Pattern pattern = Pattern.compile(AreaFactory.AREA_REGEX + "\\s" + CommandsFactory.COMMAND_REGEX);
        Matcher matcher = pattern.matcher(commands);

        if(matcher.find()) {
            return true;
        } else {
            throw new InvalidCommandException();
        }
    }
}
