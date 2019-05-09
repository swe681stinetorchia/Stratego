package org.games.stratego.model.gameplay2;

import org.games.stratego.database.GameDBConnection;
import org.games.stratego.database.PlayerDBConnection;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay2.Pieces.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {


    static Board board;

    private Player playerOne;
    private Player playerTwo;
    private User winner;
    private User loser;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;
    private boolean gameOver;
    private boolean gameStart;

    //New Game
    public Game(User userOne, User userTwo)
    {
        Player p1 = new Player(userOne);
        Player p2 = new Player(userTwo);
        this.playerOne = p1;
        this.playerTwo = p2;
        board = new Board(playerOne, playerTwo);
        instantiatePieces();
        gameOver = false;
        gameStart = false;
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

    public void move(int fromRow, int fromCol, int toRow, int toCol, String token)
    {
        if (gameOver)
        {
            throw new IllegalStateException("This game is over");
        }

        /*if (!gameStart)
        {
            throw new IllegalStateException("This game has not finished setting up.");
        }*/

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
        else if (username.equals(playerTwo.getName()))
        {
            player = playerTwo;
        }
        else
        {
            return "unauthorized";
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

    public boolean isGameStart()
    {
        return gameStart;
    }

    public boolean isGameOver()
    {
        return gameOver;
    }

    public List<Piece> getAvailablePlayerPieces(String token)
    {
        if (gameOver)
        {
            throw new IllegalArgumentException("This game is over");
        }

        String username = Sessions.checkSession(token);

        if (username.equals(playerOne.getName()))
        {
            return playerOnePieces;
        }
        else if (username.equals(playerTwo.getName()))
        {
            return playerTwoPieces;
        }
        else
        {
            return new ArrayList<Piece>();
        }
    }

    public void addPiece(int row, int col, String pieceType, String token)
    {
        System.out.println("A");
        if (gameOver)
        {
            throw new IllegalStateException("This game is over");
        }

        if (gameStart)
        {
            throw new IllegalStateException("This game has already started");
        }

        String username = Sessions.checkSession(token);
        System.out.println("B");

        if (username.equals(playerOne.getName()))
        {
            System.out.println("C: " + username + " : " + pieceType);
            Piece pieceToReturn = null;
            Iterator iterator = playerOnePieces.iterator();
            while(iterator.hasNext())
            {
                Piece pieceToTry = (Piece) iterator.next();
                if(pieceType.equals(pieceToTry.getType()))
                {
                    if(pieceToTry.isOnBoard())
                    {
                        continue;
                    }

                    if (board.hasPiece(row, col))
                    {
                        pieceToReturn = board.getPieceAt(row, col);
                        //playerOnePieces.add(board.getPieceAt(row, col));
                        board.removePiece(row, col);
                    }

                    board.addPiece(row, col, pieceToTry);
                    iterator.remove();
                    break;
                    //playerOnePieces.remove(pieceToTry);
                }
            }
            if (pieceToReturn!=null)
            {
                playerOnePieces.add(pieceToReturn);
            }
        }
        else if (username.equals(playerTwo.getName()))
        {
            System.out.println("D: " + username + " : " + pieceType);
            Piece pieceToReturn = null;
            Iterator iterator = playerTwoPieces.iterator();
            System.out.println("E: ");
            while(iterator.hasNext())
            {
                Piece pieceToTry = (Piece) iterator.next();
                System.out.println("F pieceToTry: " + pieceType + " : " + pieceToTry.getType());
                if(pieceType.equals(pieceToTry.getType()))
                {
                    System.out.println("G ");
                    if(pieceToTry.isOnBoard())
                    {
                        System.out.println("H: ");
                        continue;
                    }
                    System.out.println("I: ");

                    if (board.hasPiece(row, col))
                    {
                        System.out.println("J: ");
                        pieceToReturn = board.getPieceAt(row, col);
                        System.out.println("K: " + pieceToReturn.getType());
                        //playerTwoPieces.add(board.getPieceAt(row, col));
                        board.removePiece(row, col);
                    }
                    System.out.println("L: " + board.getPieceAt(row, col));

                    board.addPiece(row, col, pieceToTry);
                    System.out.println("M: " + board.getPieceAt(row, col));
                    iterator.remove();
                    break;
                    //playerTwoPieces.remove(pieceToTry);
                }
            }
            if (pieceToReturn!=null)
            {
                System.out.println("N: " + playerTwoPieces);
                playerTwoPieces.add(pieceToReturn);
                System.out.println("O: " + playerTwoPieces);
            }
        }
        else
        {
            return;
        }

        if ((playerOnePieces.size()<=0)&&(playerTwoPieces.size()<=0))
        {
            gameStart=true;
        }
    }

    private void instantiatePieces()
    {
        playerOnePieces = new ArrayList<Piece>();

        Flag flag = new Flag(playerOne);
        playerOnePieces.add(flag);
        Spy spy = new Spy(playerOne);
        playerOnePieces.add(spy);
        for (int i = 0; i < 8; i++)
        {
            Scout scout = new Scout(playerOne);
            playerOnePieces.add(scout);
        }
        for (int i = 0; i < 5; i++)
        {
            Minor minor = new Minor(playerOne);
            playerOnePieces.add(minor);
        }
        for (int i = 0; i < 4; i++)
        {
            Sergeant sergeant = new Sergeant(playerOne);
            playerOnePieces.add(sergeant);
        }
        for (int i = 0; i < 4; i++)
        {
            Lieutenant lieutenant = new Lieutenant(playerOne);
            playerOnePieces.add(lieutenant);
        }
        for (int i = 0; i < 4; i++)
        {
            Captain captain = new Captain(playerOne);
            playerOnePieces.add(captain);
        }
        for (int i = 0; i < 3; i++)
        {
            Major major = new Major(playerOne);
            playerOnePieces.add(major);
        }
        for (int i = 0; i < 2; i++)
        {
            Colonel colonel = new Colonel(playerOne);
            playerOnePieces.add(colonel);
        }
        General general = new General(playerOne);
        playerOnePieces.add(general);
        Marshal marshal = new Marshal(playerOne);

        for (int i = 0; i < 6; i++)
        {
            Bomb bomb = new Bomb(playerOne);
            playerOnePieces.add(bomb);
        }



        playerTwoPieces = new ArrayList<Piece>();

        Flag flag2 = new Flag(playerTwo);
        playerTwoPieces.add(flag2);
        Spy spy2 = new Spy(playerTwo);
        playerTwoPieces.add(spy2);
        for (int i = 0; i < 8; i++)
        {
            Scout scout = new Scout(playerTwo);
            playerTwoPieces.add(scout);
        }
        for (int i = 0; i < 5; i++)
        {
            Minor minor = new Minor(playerTwo);
            playerTwoPieces.add(minor);
        }
        for (int i = 0; i < 4; i++)
        {
            Sergeant sergeant = new Sergeant(playerTwo);
            playerTwoPieces.add(sergeant);
        }
        for (int i = 0; i < 4; i++)
        {
            Lieutenant lieutenant = new Lieutenant(playerTwo);
            playerTwoPieces.add(lieutenant);
        }
        for (int i = 0; i < 4; i++)
        {
            Captain captain = new Captain(playerTwo);
            playerTwoPieces.add(captain);
        }
        for (int i = 0; i < 3; i++)
        {
            Major major = new Major(playerTwo);
            playerTwoPieces.add(major);
        }
        for (int i = 0; i < 2; i++)
        {
            Colonel colonel = new Colonel(playerTwo);
            playerTwoPieces.add(colonel);
        }
        General general2 = new General(playerTwo);
        playerTwoPieces.add(general);
        Marshal marshal2 = new Marshal(playerTwo);

        for (int i = 0; i < 6; i++)
        {
            Bomb bomb = new Bomb(playerTwo);
            playerTwoPieces.add(bomb);
        }
        System.out.println("player one pieces size: "+ playerOnePieces.size());
        System.out.println("player two pieces size: "+ playerTwoPieces.size());
    }



}
