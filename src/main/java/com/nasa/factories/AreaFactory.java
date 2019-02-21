package com.nasa.factories;

import com.nasa.domain.Area;
import com.nasa.exception.InvalidCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AreaFactory {
    public static String AREA_REGEX = "^(?<top>\\d)\\s(?<right>\\d)";

    public Area create(String commands) throws InvalidCommandException {
        Pattern pattern = Pattern.compile(AREA_REGEX);
        Matcher matcher = pattern.matcher(commands);

        if(matcher.find()) {
            int topArea = Integer.parseInt(matcher.group("top"));
            int rightArea = Integer.parseInt(matcher.group("right"));

            return new Area(topArea, rightArea);
        } else {
            throw new InvalidCommandException();
        }
    }
}
