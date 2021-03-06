package org.games.stratego.model.gameplay;

import org.games.stratego.database.BoardDBConnection;
import org.games.stratego.model.gameplay.Pieces.Piece;

public class Board
{
    // 10 x 10 Grid
    Square[][] board = new Square[10][10];

    //Instantiate new board and add to db
    public Board(Player playerOne, Player playerTwo)
    {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Square square = new Square(row, col);
                if (row>5)
                {
                    square.setOwner(playerOne);
                }
                else if(row<4)
                {
                    square.setOwner(playerTwo);
                }
                board[row][col] = square;
            }
        }
    }

    //Load preexisting board from db
    public Board(int gameId)
    {
        String col_name;
        String piece_id;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                col_name ="position_" + row + "_" + col;
                //Need to bring in game_id
                BoardDBConnection db = new BoardDBConnection();
                piece_id = db.getPiece(col_name, gameId);
                //board[row][col] = db.getPiece(col_name, gameId);
            }
        }
    }

    protected void addPiece(int row, int col, Piece piece)
    {
        Player boardOwner =  board[row-1][col-1].getOwner();

        Player pieceOwner = piece.getOwner();


        if (boardOwner != null && boardOwner.equals(pieceOwner))
        {
            board[row-1][col-1].addPiece(piece);
        }
        else
        {
            throw new IllegalArgumentException("The player " + pieceOwner.getName() + " is not allowed to add pieces to the cell (" + row + "," + col +").");
        }
    }

    protected void removePiece(int row, int col, Player player)
    {

        if(board[row-1][col-1].hasPiece())
        {
            Piece piece = board[row-1][col-1].getPiece();

            if (!player.equals(piece.getOwner()))
            {
                throw new IllegalArgumentException("Invalid remove.");
            }

            board[row-1][col-1].removePiece();
        }
    }

    protected boolean hasPiece(int row, int col)
    {
        return board[row-1][col-1].hasPiece();
    }

    protected FightResult move(int fromRow, int fromCol, int toRow, int toCol)
    {
        Square fromSquare = board[fromRow-1][fromCol-1];

        Square toSquare = board[toRow-1][toCol-1];

        if (!fromSquare.hasPiece())
        {
            return FightResult.IllegalMove;
        }

        Piece piece = fromSquare.getPiece();

        if (!piece.canMove())
        {
            throw new IllegalArgumentException("This piece cannot move.");
        }

        if (!toSquare.hasPiece())
        {
            fromSquare.removePiece();
            toSquare.addPiece(piece);
            return FightResult.SuccessfulMove;
        }
        else
        {
            Piece resident = toSquare.getPiece();
            if (piece.getOwner()==resident.getOwner())
            {
                return FightResult.IllegalMove;
            }
            FightResult fightResult = resident.fight(piece);
            if (fightResult==FightResult.DefenderVictory)
            {
                fromSquare.removePiece();
                piece.kill();
                return fightResult;
            }
            if (fightResult==FightResult.AttackerVictory)
            {
                fromSquare.removePiece();
                toSquare.removePiece();
                toSquare.addPiece(piece);
                resident.kill();
                return fightResult;
            }
            if (fightResult==FightResult.BothDie)
            {
                fromSquare.removePiece();
                toSquare.removePiece();
                piece.kill();
                resident.kill();
            }
            if (fightResult==FightResult.CapturedFlag)
            {
                clearBoard();
                return fightResult;
            }
            if (fightResult==FightResult.IllegalMove)
            {
                return fightResult;
            }
            return FightResult.UndefinedResult;
        }
    }

    private void clearBoard()
    {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col].hasPiece())
                {
                    board[row][col].removePiece();
                }
            }
        }
    }


    public void setGameId(String gameId)
    {

    }

    public Piece getPieceAt(int row, int col)
    {
        return board[row-1][col-1].getPiece();
    }
}