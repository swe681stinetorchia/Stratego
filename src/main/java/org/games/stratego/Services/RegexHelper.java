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
    //Move format is currRow:currCol moveRow:move:Col
    public Boolean isMoveRegex (String input)
    {
        String regex = "^([1-9]|10){1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    //Move format is currRow:currCol moveRow:move:Col
    public Boolean isOldMoveRegex (String input)
    {
        String regex = "^([1-9]|10){1}:([1-9]|10){1} ([1-9]|10){1}:([1-9]|10){1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
}
