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
        System.out.println("j");
        if (piece != null)
        {
            System.out.println("k");
            if (!piece.isOnBoard())
            {
                System.out.println("l");
                throw new RuntimeException("Piece is listed in the square (" + row + "," + column + ") doesn't have the 'isOnBoard' attribute.");
            }
            System.out.println("m");
            piece.removeFromBoard();
            System.out.println("n");
        }
        System.out.println("o: " + owner);

        Player pieceOwner = pieceToAdd.getOwner();
        System.out.println("p: " + pieceOwner);

        System.out.println("Compare " + owner.getName() + " to " + pieceOwner.getName());
        if (owner != null && owner.equals(pieceOwner))
        {
            System.out.println("q");
            piece = pieceToAdd;
        }
        else
        {
            System.out.println("r");
            throw new IllegalArgumentException("The player " + pieceOwner.getName() + " is not allowed to add pieces to the cell (" + row + "," + column +").");
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
        piece = null;
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
