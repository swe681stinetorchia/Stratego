package org.games.stratego.model.gameplay;

import org.games.stratego.model.gameplay.Pieces.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {


    String[][] board = new String[10][10];

    private Player playerOne;
    private Player playerTwo;
    private Player winner;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;

    public Game(Player playerOne, Player playerTwo, Player winner)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = winner;
        instantiateBoard();

    }

    public Game(Player playerOne, Player playerTwo, String[][] board)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
    }

    public Game(Player playerOne, Player playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = null;
        instantiateBoard();
    }



    private void instantiateBoard()
    {

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                board[i][j]="Empty";
            }
        }
    }

}
