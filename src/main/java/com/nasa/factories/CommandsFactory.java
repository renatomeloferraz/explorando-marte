package com.nasa.factories;

import com.nasa.domain.Area;
import com.nasa.domain.Command;
import com.nasa.domain.State;
import com.nasa.exception.InvalidSequenceException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandsFactory {
    public static final String COMMAND_REGEX = "(?<x>\\d)\\s(?<y>\\d)\\s(?<direction>[N|S|W|E])\\s(?<movements>[M|R|L]*)";

    public List<Command> create(Area area, String sequence) throws InvalidSequenceException {
        List<Command> commands = new ArrayList<>();
        Matcher matcher = Pattern.compile(COMMAND_REGEX).matcher(sequence);

        while (matcher.find()) {
            commands.add(new Command(
                    Integer.parseInt(matcher.group("x")),
                    Integer.parseInt(matcher.group("y")),
                    getState(matcher.group("direction" )),
                    matcher.group("movements" ).split(""),
                    area));
        }

        return commands;
    }

    private State getState(String direction) throws InvalidSequenceException {
        switch (direction) {
            case "N":
                return State.N;
            case "S":
                return State.S;
            case "E":
                return State.E;
            case "W":
                return State.W;
            default:
                throw new InvalidSequenceException();
        }
    }
}
