package org.games.stratego.model.gameplay2;
import org.games.stratego.database.BoardDBConnection;
import org.games.stratego.model.gameplay.Pieces.Piece;

public class Board
{
    // 10 x 10 Grid
    String[][] board = new String[10][10];

    //Instantiate new board and add to db
    public Board()
    {

    }

    //Load preexisting board from db
    public Board(String gameId)
    {
        String col_name;
        String piece_id;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                col_name ="position_" + row + "_" + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                piece_id = db.getPiece(col_name, gameId);
                board[row][col] = db.getPiece(col_name, gameId);
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

    public void setGameId(String gameId)
    {

    }

    public Piece getPieceAt(int row, int col)
    {

    }

    public boolean pieceAt(int row, int col)
    {
    }
}