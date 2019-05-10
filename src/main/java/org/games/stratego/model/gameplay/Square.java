package org.games.stratego.model.gameplay;

import org.games.stratego.model.gameplay.Pieces.Piece;

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

    protected void setOwner(Player player)
    {
        this.owner = player;
    }

    protected Player getOwner()
    {
        return owner;
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
        piece = pieceToAdd;
        piece.addToBoard();
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
        piece = null;
    }

    public boolean hasPiece()
    {
        return (piece!=null);
    }
}
