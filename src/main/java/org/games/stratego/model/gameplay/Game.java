package org.games.stratego.model.gameplay;

import org.games.stratego.database.GameDBConnection;
import org.games.stratego.database.PlayerDBConnection;
import org.games.stratego.model.admin.Sessions;
import org.games.stratego.model.admin.User;
import org.games.stratego.model.gameplay.Pieces.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {


    static Board board;

    private Player playerOne;
    private Player playerTwo;
    private Player ownerOfTurn;
    private User winner;
    private User loser;
    private List<Piece> playerOnePieces;
    private List<Piece> playerTwoPieces;
    private boolean gameOver;
    private boolean gameStart;
    private String gameId;

    //New Game
    public Game(User userOne, User userTwo, String gameId)
    {
        this.gameId = gameId;
        Player p1 = new Player(userOne);
        Player p2 = new Player(userTwo);
        this.playerOne = p1;
        this.playerTwo = p2;
        board = new Board(playerOne, playerTwo);
        instantiatePieces();
        gameOver = false;
        gameStart = false;
    }

    public String move(int fromRow, int fromCol, int toRow, int toCol, String token)
    {

        if (!gameStart)
        {
            throw new IllegalStateException("This game has not finished setting up.");
        }

        if (fromRow>10||fromRow<1||fromCol>10||fromCol<1)
        {
            throw new IllegalArgumentException("Invalid coordinates.");
        }

        if (toRow>10||toRow<1||toCol>10||toCol<1)
        {
            throw new IllegalArgumentException("Invalid coordinates.");
        }

        String username = Sessions.checkSession(token);

        Player player;

        if (username.equals(playerOne.getName()))
        {

            if (gameOver)
            {
                if (playerOne.getUser().equals(winner))
                {
                    throw new IllegalStateException("This game is over. You won!");
                }
                else if (playerOne.getUser().equals(loser))
                {
                    throw new IllegalStateException("This game is over. You lost!");
                }
                else
                {
                    throw new IllegalStateException("This game is over. Stalemate?");
                }
            }

            if (!playerOne.equals(ownerOfTurn))
            {
                throw new IllegalStateException("It is not this player's turn.");
            }
            player = playerOne;
        }
        else if (username.equals(playerTwo.getName()))
        {

            if (gameOver)
            {
                if (playerTwo.getUser().equals(winner))
                {
                    throw new IllegalStateException("This game is over. You won!");
                }
                else if (playerTwo.getUser().equals(loser))
                {
                    throw new IllegalStateException("This game is over. You lost!");
                }
                else
                {
                    throw new IllegalStateException("This game is over. Stalemate?");
                }
            }

            if (!playerTwo.equals(ownerOfTurn))
            {
                throw new IllegalArgumentException("It is not this player's turn.");
            }
            player = playerTwo;
        }
        else
        {
            throw new IllegalStateException("Not a participant in this game.");
        }

        FightResult fightResult = board.move(fromRow, fromCol, toRow, toCol);

        if (ownerOfTurn.equals(playerOne))
        {
            ownerOfTurn = playerTwo;
        }
        else
        {
            ownerOfTurn = playerOne;
        }

        if (fightResult == FightResult.CapturedFlag)
        {
            if (player==playerOne)
            {
                winner = playerOne.getUser();
                loser = playerTwo.getUser();
                gameOver = true;
                GameDBConnection gameDBConnection = new GameDBConnection();
                gameDBConnection.addCompletedGame(gameId, winner.getName(), loser.getName());
            }
            if (player==playerTwo)
            {
                winner = playerTwo.getUser();
                loser = playerOne.getUser();
                gameOver = true;
                GameDBConnection gameDBConnection = new GameDBConnection();
                gameDBConnection.addCompletedGame(gameId, winner.getName(), loser.getName());
            }
            return "Victory!";
        }
        else if (fightResult == FightResult.AttackerVictory)
        {
            return "Killed piece.";
        }
        else if (fightResult == FightResult.DefenderVictory)
        {
            return "Killed by piece.";
        }
        else if (fightResult == FightResult.BothDie)
        {
            return "Bomb!";
        }
        else if (fightResult == FightResult.SuccessfulMove)
        {
            return "Movement made";
        }
        else if (fightResult == FightResult.IllegalMove)
        {
            return "Cannot move there.";
        }
        else if (fightResult == FightResult.UndefinedResult)
        {
            return "Undefined result.";
        }
        else
        {
            return "Nothing.";
        }
    }

    String getPieceAt(int row, int col, String token)
    {
        if (row>10||row<1||col>10||col<1)
        {
            throw new IllegalArgumentException("Invalid coordinates.");
        }

        String username = Sessions.checkSession(token);

        Player player;

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

    List<Piece> getAvailablePlayerPieces(String token)
    {
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

    public void surrender(String token)
    {
        if (gameOver)
        {
            return;
        }

        String username = Sessions.checkSession(token);

        if (username.equals(playerOne.getName()))
        {
            loser = playerOne.getUser();
            winner = playerTwo.getUser();
        }
        else if (username.equals(playerTwo.getName()))
        {
            loser = playerTwo.getUser();
            winner = playerOne.getUser();
        }
        gameOver = true;
    }

    public void addPiece(int row, int col, String pieceType, String token)
    {
        if (gameOver)
        {
            throw new IllegalStateException("This game is over");
        }

        if (gameStart)
        {
            throw new IllegalStateException("This game has already started");
        }


        if (row>10||row<1||col>10||col<1)
        {
            throw new IllegalArgumentException("Invalid coordinates.");
        }

        String username = Sessions.checkSession(token);

        if (username.equals(playerOne.getName()))
        {
            Piece pieceToReturn = null;
            Iterator iterator = playerOnePieces.iterator();
            while(iterator.hasNext())
            {
                Piece pieceToTry = (Piece) iterator.next();
                if(pieceType.equals(pieceToTry.getType()))
                {

                    if (board.hasPiece(row, col))
                    {
                        pieceToReturn = board.getPieceAt(row, col);
                        //playerOnePieces.add(board.getPieceAt(row, col));
                        board.removePiece(row, col, playerOne);
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
            Piece pieceToReturn = null;

            Iterator iterator = playerTwoPieces.iterator();

            while(iterator.hasNext())
            {
                Piece pieceToTry = (Piece) iterator.next();

                if(pieceType.equals(pieceToTry.getType()))
                {

                    if (board.hasPiece(row, col))
                    {
                        pieceToReturn = board.getPieceAt(row, col);

                        //playerTwoPieces.add(board.getPieceAt(row, col));
                        board.removePiece(row, col, playerTwo);
                    }

                    board.addPiece(row, col, pieceToTry);

                    iterator.remove();

                    break;
                }
            }
            if (pieceToReturn!=null)
            {
                playerTwoPieces.add(pieceToReturn);
            }
        }
        else
        {
            return;
        }

        if ((playerOnePieces.size()<=0)&&(playerTwoPieces.size()<=0))
        {
            gameStart=true;
            ownerOfTurn = playerOne;
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
            Miner miner = new Miner(playerOne);
            playerOnePieces.add(miner);
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
        playerOnePieces.add(marshal);


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
            Miner miner = new Miner(playerTwo);
            playerTwoPieces.add(miner);
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
        playerTwoPieces.add(general2);
        Marshal marshal2 = new Marshal(playerTwo);
        playerTwoPieces.add(marshal2);

        for (int i = 0; i < 6; i++)
        {
            Bomb bomb = new Bomb(playerTwo);
            playerTwoPieces.add(bomb);
        }
    }



}
