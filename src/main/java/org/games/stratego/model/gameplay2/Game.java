package org.games.stratego.model.gameplay2;

import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay.Pieces.Piece;
import org.games.stratego.model.gameplay.Player;

import java.util.List;

public class Game {


    String[][] board = new String[10][10];

    private Player playerOne;
    private Player playerTwo;
    private User winner;
    private User loser;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;

    //New Game
    public Game(User userOne, User userTwo)
    {
        Player p1 = new Player(userOne.getName(), userOne);
        Player p2 = new Player(userTwo.getName(), userTwo);
        this.playerOne = p1;
        this.playerTwo = p2;
        instantiateBoard();
    }

    public static Game loadPreviousGame(String gameId)
    {

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
