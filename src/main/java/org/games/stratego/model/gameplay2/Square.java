package org.games.stratego.model.gameplay2;

import org.games.stratego.model.gameplay2.Pieces.Piece;
import org.games.stratego.model.gameplay2.Player;

public class Square {

    private Piece piece;
    private Player owner;
    private int row;
    private int column;

    public Square(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    protected void addPiece(Piece pieceToAdd)
    {
        if (piece != null)
        {
            if (!piece.isOnBoard())
            {
                throw new RuntimeException("Piece is listed in the square (" + row + "," + column + ") doesn't have the 'isOnBoard' attribute.");
            }
            piece.removeFromBoard();
        }

        Player pieceOwner = pieceToAdd.getOwner();

        if (owner != null && owner.equals(pieceOwner))
        {
            piece = pieceToAdd;
        }
        else
        {
            throw new IllegalArgumentException("The player " + owner.getName() + " is not allowed to add pieces to the cell (" + row + "," + column +").");
        }
    }

    protected Piece getPiece()
    {
        if (piece==null)
        {
            return null;
        }
        return piece;
    }

    protected void removePiece()
    {
        if (piece != null)
        {
            if (!piece.isOnBoard())
            {
                throw new RuntimeException("Piece is listed in the square (" + row + "," + column + ") doesn't have the 'isOnBoard' attribute.");
            }
            piece.removeFromBoard();
        }
    }

    public boolean hasPiece()
    {
        return (piece!=null);
    }

    public String readPiece(Player reader)
    {
        if (piece==null)
        {
            return null;
        }

        if (reader == piece.getOwner())
        {
            return piece.getType();
        }

        return "A Piece";
    }
}
