package com.nasa.factories;

import com.nasa.domain.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandsFactory {
    public static final String COMMAND_REGEX = "(?<x>\\d)\\s(?<y>\\d)\\s(?<direction>[N|S|W|E])\\s(?<movements>[M|R|L]*)";

    public List<Command> create(String sequence) {
        List<Command> commands = new ArrayList<>();
        Matcher matcher = Pattern.compile(COMMAND_REGEX).matcher(sequence);

        while (matcher.find()) {
            commands.add(new Command(
                    Integer.parseInt(matcher.group("x")),
                    Integer.parseInt(matcher.group("y")),
                    matcher.group("direction" ),
                    matcher.group("movements" ).split("")
            ));
        }

        return commands;
    }
}
