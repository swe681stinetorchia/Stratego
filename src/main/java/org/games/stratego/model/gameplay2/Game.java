package org.games.stratego.model.gameplay2;

import org.games.stratego.database.GameDBConnection;
import org.games.stratego.database.PlayerDBConnection;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay2.Pieces.Piece;

import java.util.List;

public class Game {


    static Board board;

    static private Player playerOne;
    static private Player playerTwo;
    static private User winner;
    static private User loser;
    static private List<Piece> playerOnePieces;
    static private List<Piece> playerTwoPieces;
    static private boolean gameOver;

    //New Game
    public Game(User userOne, User userTwo)
    {
        Player p1 = new Player(userOne);
        Player p2 = new Player(userTwo);
        this.playerOne = p1;
        this.playerTwo = p2;
        board = new Board();
        gameOver = false;
    }

    public Game(int gameId)
    {
        GameDBConnection gameDBConnection = new GameDBConnection();

        int loserId = gameDBConnection.getLoserId(gameId);
        if (loserId==-1)
        {
            loser = null;
        }
        else
        {
            loser = new User(loserId);
        }

        int winnerId = gameDBConnection.getWinnerId(gameId);
        if (winnerId==-1)
        {
            winner = null;
        }
        else
        {
            winner = new User(winnerId);
        }

        PlayerDBConnection playerDBConnection = new PlayerDBConnection();

        int playerOneId = gameDBConnection.getPlayerOneId(gameId);
        int playerOneUserId = playerDBConnection.getUserId(playerOneId);
        playerOne = new Player(new User(playerOneUserId));

        int playerTwoId = gameDBConnection.getPlayerTwoId(gameId);
        int playerTwoUserId = playerDBConnection.getUserId(playerTwoId);
        playerTwo = new Player(new User(playerTwoUserId));

        board = new Board(gameId);

        gameOver = false;
    }

    protected void move(int fromRow, int fromCol, int toRow, int toCol, String token) throws IllegalAccessException
    {
        if (gameOver)
        {
            throw new IllegalArgumentException("This game is over");
        }

        String username = Sessions.checkSession(token);

        Player player = null;

        if (username.equals(playerOne.getName()))
        {
            player = playerOne;
        }
        else if (username.equals(playerOne.getName()))
        {
            player = playerTwo;
        }
        else
        {
            return;
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

    public String getPieceAt(int row, int col, String token)
    {
        if (gameOver)
        {
            throw new IllegalArgumentException("This game is over");
        }

        String username = Sessions.checkSession(token);

        Player player = null;

        if (username.equals(playerOne.getName()))
        {
            player = playerOne;
        }
        else if (username.equals(playerOne.getName()))
        {
            player = playerTwo;
        }
        else
        {
            return "Unauthorized";
        }

        Piece piece = board.getPieceAt(row, col);

        if (piece==null)
        {
            return "blank";
        }

        if(player.equals(piece.getOwner()))
        {
            return piece.getType();
        }

        return "piece";
    }

    public Player getPlayerOne()
    {
        return playerOne;
    }

    public Player getPlayerTwo()
    {
        return playerTwo;
    }

}
