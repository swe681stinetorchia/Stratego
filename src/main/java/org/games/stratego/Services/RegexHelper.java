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
    //Move format is 1-10
    public Boolean isMoveRegex (String input)
    {
        String regex = "^([1-9]|10)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean isValidPiece(String pieceName)
    {
        String regex = "^([sS][pP][yY])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([sS][eE][rR][gG][eE][aA][nN][tT])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([sS][cC][oO][uU][tT])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([mM][iI][nN][eE][rR])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([mM][aA][rR][sS][hH][aA][lL])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([mM][aA][jJ][oO][rR])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([lL][iI][eE][uU][tT][eE][nN][aA][nN][tT])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([gG][eE][nN][eE][rR][aA][lL])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([fF][lL][aA][gG])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([cC][oO][lL][oO][nN][eE][lL])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([cC][aA][pP][tT][aA][iI][nN])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        regex = "^([bB][oO][mM][bB])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(pieceName);
        if (matcher.matches()) {return true;}

        return false;
    }

}
