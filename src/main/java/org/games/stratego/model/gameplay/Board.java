package org.games.stratego.model.gameplay;
import org.games.stratego.database.BoardDBConnection;
import java.util.*;

import static org.games.stratego.database.BoardDBConnection.*;

public class Board
{
    // 10 x 10 Grid
    String[][] board = new String[10][10];

    public Board()
    {
        String col_name;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                col_name ="position_" + row + "_" + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                board[row][col] = db.getPiece(col_name, "11");
            }
        }

        /**
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + "\t");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.print("\t");
        for(int row = 0; row < 10; row++) {
            System.out.print((row + 1) + "\t");
        }*/
    }
}