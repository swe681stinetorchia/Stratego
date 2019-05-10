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
        System.out.println("66");
        if (piece != null)
        {
            System.out.println("77");
            if (!piece.isOnBoard())
            {
                System.out.println("88: " + "Piece is listed in the square (" + row + "," + column + ") doesn't have the 'isOnBoard' attribute.");
                throw new RuntimeException("Piece is listed in the square (" + row + "," + column + ") doesn't have the 'isOnBoard' attribute.");
            }
            System.out.println("99");
            piece.removeFromBoard();
            System.out.println("1010");
        }
        System.out.println("1111");
        piece = pieceToAdd;
        System.out.println("1212");
        piece.addToBoard();
        System.out.println("1313");
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
