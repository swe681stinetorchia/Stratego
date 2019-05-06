package org.games.stratego.model.gameplay2;

import org.games.stratego.model.gameplay.Pieces.Piece;
import org.games.stratego.model.gameplay.Player;

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

    public void addPiece(Piece pieceToAdd)
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

    public void removePiece()
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
}
