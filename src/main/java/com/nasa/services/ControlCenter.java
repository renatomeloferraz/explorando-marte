package com.nasa.services;

import com.nasa.exception.InvalidCommandException;
import com.nasa.factories.AreaFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlCenter {

    private final String COMMAND_REGEX = "(?:(\\d\\s\\d\\s[N|S|W|E]\\s[M|R|L]*))+";

    private final AreaFactory areaFactory;

    public ControlCenter(AreaFactory areaFactory) {
        this.areaFactory = areaFactory;
    }

    public void execute(String commands) throws InvalidCommandException {
        if(isValidCommands(commands)) {
            areaFactory.create(commands);
        }
    }

    private boolean isValidCommands(String commands) throws InvalidCommandException {
        Pattern pattern = Pattern.compile(AreaFactory.AREA_REGEX + "\\s" + COMMAND_REGEX);
        Matcher matcher = pattern.matcher(commands);

        if(matcher.find()) {
            return true;
        } else {
            throw new InvalidCommandException();
        }
    }
}
