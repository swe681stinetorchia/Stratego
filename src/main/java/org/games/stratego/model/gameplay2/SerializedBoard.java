package org.games.stratego.model.gameplay2;

import java.io.Serializable;

import org.games.stratego.model.gameplay2.Pieces.Piece;

public class SerializedBoard implements Serializable {

    private static final long serialVersionUID = 1854992492401962054L;
    private Square[][] pieces = new Square[10][10];

    public Square getPiece(int row, int col) {
        return pieces[row][col];
    }

    public void setPiece(Square piece, int row, int col) {
        pieces[row][col] = piece;
    }
}
