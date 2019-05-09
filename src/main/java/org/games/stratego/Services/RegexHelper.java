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


    private Boolean legitMove(int curRow, int curCol, int moveRow, int moveCol) {
        Boolean legit = false;

        if(curRow == moveRow){
            if((curCol == moveCol + 1) || (curCol == moveCol - 1)) {
                legit = true;
            }
        }
        else if(curCol == moveCol)
        {
            if((curRow == moveRow + 1) || (curRow == moveRow - 1)) {
                legit = true;
            }
        }
        else {
            legit = false;
        }
        return legit;
    }
}
