package org.games.stratego.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {


    public Boolean isAlphaNumericRegex (String input)
    {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public Boolean isMoveRegex (String input)
    {
        //Regex check for piece:row:col
        String regex = "^([1-9]|10){1}:([1-9]|10){1}:([1-9]|10){1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
