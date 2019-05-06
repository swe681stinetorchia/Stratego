package org.games.stratego.model.gameplay2;

import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay2.Pieces.Piece;
import org.games.stratego.model.gameplay2.Player;

import java.util.List;

public class Game {


    Board board;

    private Player playerOne;
    private Player playerTwo;
    private User winner;
    private User loser;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;
    private boolean gameOver;

    //New Game
    public Game(User userOne, User userTwo)
    {
        Player p1 = new Player(userOne.getName(), userOne);
        Player p2 = new Player(userTwo.getName(), userTwo);
        this.playerOne = p1;
        this.playerTwo = p2;
        board = new Board();
        gameOver = false;
    }

    /**public static Game loadPreviousGame(String gameId)
    {

    }**/

    protected void move(int fromRow, int fromCol, int toRow, int toCol, Player player)
    {
        if (gameOver)
        {
            throw new IllegalArgumentException("This game is over");
        }
        FightResult fightResult = board.move(fromRow, fromCol, toRow, toCol);

        if (fightResult == FightResult.CapturedFlag)
        {
            if (player==playerOne)
            {
                winner = playerOne.getUser();
                loser = playerTwo.getUser();
                gameOver = true;
            }
            if (player==playerTwo)
            {
                winner = playerTwo.getUser();
                loser = playerOne.getUser();
                gameOver = true;
            }
        }
    }

    public Player getPlayerOne()
    {
        return playerOne;
    }

    public Player getPlayerTwo()
    {
        return playerTwo;
    }

    public Board getBoard()
    {
        return board;
    }

}
