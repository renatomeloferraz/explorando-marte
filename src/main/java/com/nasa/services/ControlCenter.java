package com.nasa.services;

import com.nasa.exception.InvalidCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlCenter {

    private final String AREA_REGEX = "^(\\d)\\s(\\d)";
    private final String COMMAND_REGEX = "(?:(\\d\\s\\d\\s[N|S|W|E]\\s[M|R|L]*))+";

    public void execute(String commands) throws InvalidCommandException {
        if(isValidCommands(commands)) {

        }
    }

    private boolean isValidCommands(String commands) throws InvalidCommandException {
        Pattern pattern = Pattern.compile(AREA_REGEX + "\\s" + COMMAND_REGEX);
        Matcher matcher = pattern.matcher(commands);

        if(matcher.find()) {
            return true;
        } else {
            throw new InvalidCommandException();
        }
    }
}
